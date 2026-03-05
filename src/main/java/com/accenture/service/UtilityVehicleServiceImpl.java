package com.accenture.service;

import com.accenture.exception.UtilityVehicleException;
import com.accenture.models.UtilityVehicle;
import com.accenture.repository.UtilityVehicleRepository;
import com.accenture.service.dto.UtilityVehicleRequestDto;
import com.accenture.service.dto.UtilityVehicleResponseDto;
import com.accenture.service.mapper.UtilityVehicleMapper;
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
public class UtilityVehicleServiceImpl implements UtilityVehicleService{

    private static final String UTILITY_VEHICLE_NOT_FOUND = "utilityVehicle.id.notfound";

    private final UtilityVehicleRepository utilityVehicleRepository;
    private final UtilityVehicleMapper utilityVehicleMapper;
    private final MessageSourceAccessor messages;

    @Override
    public void addUtilityVehicle(UtilityVehicleRequestDto dto) throws UtilityVehicleException {
        check(dto);
        UtilityVehicle utilityVehicle = utilityVehicleMapper.toUtilityVehicle(dto);
        utilityVehicleRepository.save(utilityVehicle);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UtilityVehicleResponseDto> findAll() {
        return utilityVehicleRepository.findAll().stream()
                .map(utilityVehicleMapper::toUtilityVehicleResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UtilityVehicleResponseDto findById(UUID id) {
        Optional<UtilityVehicle> opt = utilityVehicleRepository.findById(id);
        if(opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage(UTILITY_VEHICLE_NOT_FOUND));
        return utilityVehicleMapper.toUtilityVehicleResponseDto(opt.get());
    }

    @Override
    public void deleteUtilityVehicle(UUID id) {
        if(!utilityVehicleRepository.existsById(id))
            throw new EntityNotFoundException(messages.getMessage(UTILITY_VEHICLE_NOT_FOUND));
        utilityVehicleRepository.deleteById(id);
    }

    @Override
    public UtilityVehicleResponseDto modifyUtilityVehicle(UUID id, UtilityVehicleRequestDto dto) {
        UtilityVehicle utilityVehicle = utilityVehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(UTILITY_VEHICLE_NOT_FOUND)));
        check(dto);
        utilityVehicle.setBrand(dto.brand());
        utilityVehicle.setModel(dto.model());
        utilityVehicle.setType(dto.type());
        utilityVehicle.setColor(dto.color());
        utilityVehicle.setLicense(dto.license());
        utilityVehicle.setMileage(dto.mileage());
        utilityVehicle.setDailyBaseRate(dto.dailyBaseRate());
        utilityVehicle.setActive(dto.active());
        utilityVehicle.setRemovedFromPark(dto.removedFromPark());
        utilityVehicle.setNumberOfSeats(dto.numberOfSeats());
        utilityVehicle.setEnergySources(dto.energySources());
        utilityVehicle.setTransmission(dto.transmission());
        utilityVehicle.setAirConditioning(dto.airConditioning());
        utilityVehicle.setMaximumWeight(dto.maximumWeight());
        utilityVehicle.setWeight(dto.weight());
        utilityVehicle.setCapacity(dto.capacity());
        UtilityVehicle saved = utilityVehicleRepository.save(utilityVehicle);
        return utilityVehicleMapper.toUtilityVehicleResponseDto(saved);
    }

    @Override
    public UtilityVehicleResponseDto partiallyModifyingUtilityVehicle(UUID id, UtilityVehicleRequestDto dto) {
        UtilityVehicle utilityVehicle = utilityVehicleRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(UTILITY_VEHICLE_NOT_FOUND)));
        if (dto.brand() != null && !dto.brand().isBlank()) {
            utilityVehicle.setBrand(dto.brand());
        }
        if (dto.model() != null && !dto.model().isBlank()) {
            utilityVehicle.setModel(dto.model());
        }
        if (dto.type() != null && !dto.type().isBlank()) {
            utilityVehicle.setType(dto.type());
        }
        if (dto.color() != null && !dto.color().isBlank()) {
            utilityVehicle.setColor(dto.color());
        }
        if (dto.license() != null && !dto.license().isBlank()) {
            utilityVehicle.setLicense(dto.license());
        }
        if (dto.mileage() < 0) {
            utilityVehicle.setMileage(dto.mileage());
        }
        if (dto.dailyBaseRate() < 0) {
            utilityVehicle.setDailyBaseRate(dto.dailyBaseRate());
        }

            utilityVehicle.setActive(dto.active());


            utilityVehicle.setRemovedFromPark(dto.removedFromPark());

        if (dto.numberOfSeats() < 0) {
            utilityVehicle.setNumberOfSeats(dto.numberOfSeats());
        }
        if (dto.energySources() != null && !dto.energySources().isBlank()) {
            utilityVehicle.setEnergySources(dto.energySources());
        }
        if (dto.transmission() != null && !dto.transmission().isBlank()) {
            utilityVehicle.setTransmission(dto.transmission());
        }

        if (dto.maximumWeight() < 0 ) {
            utilityVehicle.setMaximumWeight(dto.maximumWeight());
        }
        if (dto.weight() < 0) {
            utilityVehicle.setWeight(dto.weight());
        }
        if (dto.capacity() < 0) {
            utilityVehicle.setCapacity(dto.capacity());
        }
        UtilityVehicle saved = utilityVehicleRepository.save(utilityVehicle);
        return utilityVehicleMapper.toUtilityVehicleResponseDto(saved);
    }

    private void check(UtilityVehicleRequestDto dto) {
        if(dto == null)
            throw new UtilityVehicleException(messages.getMessage("utilityVehicle.null"));
    }
}
