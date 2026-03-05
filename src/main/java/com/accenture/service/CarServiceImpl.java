package com.accenture.service;

import com.accenture.exception.CarException;
import com.accenture.models.Car;
import com.accenture.repository.CarRepository;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import com.accenture.service.mapper.CarMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class CarServiceImpl implements CarService{

    private static final String CAR_NOT_FOUND = "car.id.notfound";

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final MessageSourceAccessor messages;

    @Override
    public void addCar(CarRequestDto dto) throws CarException {
        check(dto);
        Car car = carMapper.toCar(dto);
        carRepository.save(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarResponseDto> findAll() {
        return carRepository.findAll().stream()
                .map(carMapper::toCarResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CarResponseDto findById(UUID id) {
        Optional<Car> opt = carRepository.findById(id);
        if(opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage(CAR_NOT_FOUND));
        return carMapper.toCarResponseDto(opt.get());
    }

    @Override
    public void deleteCar(UUID id) {
        if (!carRepository.existsById(id))
            throw new EntityNotFoundException(messages.getMessage(CAR_NOT_FOUND));
        carRepository.deleteById(id);
    }

    @Override
    public CarResponseDto modifyCar(UUID id, CarRequestDto dto) {
        Car car = carRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(CAR_NOT_FOUND)));
        check(dto);
        car.setBrand(dto.brand());
        car.setModel(dto.model());
        car.setType(dto.type());
        car.setColor(dto.color());
        car.setLicense(dto.license());
        car.setMileage(dto.mileage());
        car.setDailyBaseRate(dto.dailyBaseRate());
        car.setActive(dto.active());
        car.setRemovedFromPark(dto.removedFromPark());
        car.setNumberOfSeats(dto.numberOfSeats());
        car.setEnergySources(dto.energySources());
        car.setNumberOfDoors(dto.numberOfDoors());
        car.setTransmission(dto.transmission());
        car.setAirConditioning(dto.airConditioning());
        car.setNumberOfLuggages(dto.numberOfLuggages());
        Car saved = carRepository.save(car);
        return carMapper.toCarResponseDto(saved);
    }

    @Override
    public CarResponseDto partiallyModifyingCar(UUID id, CarRequestDto dto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(CAR_NOT_FOUND)));
        if (dto.brand() != null && !dto.brand().isBlank()) {
            car.setBrand(dto.brand());
        }
        if (dto.model() != null && !dto.model().isBlank()) {
            car.setModel(dto.model());
        }
        if (dto.type() != null && !dto.type().isBlank()) {
            car.setType(dto.type());
        }
        if (dto.color() != null && !dto.color().isBlank()) {
            car.setColor(dto.color());
        }
        if (dto.license() != null && !dto.license().isBlank()) {
            car.setLicense(dto.license());
        }
        if (dto.mileage() < 0) {
            car.setMileage(dto.mileage());
        }
        if (dto.dailyBaseRate() < 0) {
            car.setDailyBaseRate(dto.dailyBaseRate());
        }

            car.setActive(dto.active());


            car.setRemovedFromPark(dto.removedFromPark());

        if (dto.numberOfSeats() < 0) {
            car.setNumberOfSeats(dto.numberOfSeats());
        }
        if (dto.energySources() != null && !dto.energySources().isBlank()) {
            car.setEnergySources(dto.energySources());
        }
        if (dto.numberOfDoors() < 0) {
            car.setNumberOfDoors(dto.numberOfDoors());
        }
        if (dto.transmission() != null && !dto.transmission().isBlank()) {
            car.setTransmission(dto.transmission());
        }
        if (dto.numberOfLuggages() < 0) {
            car.setNumberOfLuggages(dto.numberOfLuggages());
        }
        Car saved = carRepository.save(car);
        return carMapper.toCarResponseDto(saved);
    }


    private void check(CarRequestDto dto) {
        if(dto == null)
            throw new CarException(messages.getMessage("car.null"));
    }
}
