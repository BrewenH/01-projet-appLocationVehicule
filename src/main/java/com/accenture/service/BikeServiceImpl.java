package com.accenture.service;

import com.accenture.exception.BikeException;
import com.accenture.models.Bike;
import com.accenture.repository.BikeRepository;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;
import com.accenture.service.mapper.BikeMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class BikeServiceImpl implements BikeService {

    private static final String BIKE_NOT_FOUND = "bike.id.notfound";

    private final BikeRepository bikeRepository;
    private final BikeMapper bikeMapper;
    private final MessageSourceAccessor messages;

    @Override
    public void addBike(BikeRequestDto dto) throws BikeException {
        check(dto);
        Bike bike = bikeMapper.toBike(dto);
        bikeRepository.save(bike);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BikeResponseDto> findAll() {
        return bikeRepository.findAll().stream()
                .map(bikeMapper::toBikeResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BikeResponseDto findById(int id) {
        Optional<Bike> opt = bikeRepository.findById(id);
        if (opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage(BIKE_NOT_FOUND));
        return bikeMapper.toBikeResponseDto(opt.get());
    }

    @Override
    public void deleteBike(int id) {
        if (!bikeRepository.existsById(id))
            throw new EntityNotFoundException(messages.getMessage(BIKE_NOT_FOUND));
        bikeRepository.deleteById(id);
    }
    @Override
    public BikeResponseDto modifyBike(int id, BikeRequestDto dto) throws BikeException {
        Bike bike = bikeRepository.findById(id)
                        .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(BIKE_NOT_FOUND)));
        check(dto);
        bike.setBrand(dto.brand());
        bike.setModel(dto.model());
        bike.setType(dto.type());
        bike.setColor(dto.color());
        bike.setLicense(dto.license());
        bike.setMileage(dto.mileage());
        bike.setDailyBaseRate(dto.dailyBaseRate());
        bike.setActive(dto.active());
        bike.setRemovedFromPark(dto.removedFromPark());
        bike.setFrameSize(dto.frameSize());
        bike.setWeight(dto.weight());
        bike.setElectric(dto.electric());
        bike.setDiscBrakes(dto.discBrakes());
        Bike saved = bikeRepository.save(bike);
        return bikeMapper.toBikeResponseDto(saved);
    }

    @Override
    public BikeResponseDto partiallyModifyingBike(int id, BikeRequestDto dto) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(BIKE_NOT_FOUND)));
        if(dto.brand() != null && !dto.brand().isBlank()) {
            bike.setBrand(dto.brand());
        }
        if(dto.model() != null && !dto.model().isBlank()) {
            bike.setModel(dto.model());
        }
        if(dto.type() != null && !dto.type().isBlank()) {
            bike.setType(dto.type());
        }
        if(dto.color() != null && !dto.color().isBlank()) {
            bike.setColor(dto.color());
        }
        if(dto.license() != null && !dto.license().isBlank()) {
            bike.setLicense(dto.license());
        }
        if(dto.mileage() < 0) {
            bike.setBrand(dto.brand());
        }
        if(dto.dailyBaseRate() < 0) {
            bike.setBrand(dto.brand());
        }
        if(dto.active() != null && !dto.active().isBlank()) {
            bike.setActive(dto.active());
        }
        if(dto.removedFromPark() != null && !dto.removedFromPark().isBlank()) {
            bike.setRemovedFromPark(dto.removedFromPark());
        }
        if(dto.frameSize() < 0) {
            bike.setFrameSize(dto.frameSize());
        }
        if(dto.weight() < 0) {
            bike.setWeight(dto.weight());
        }
        if(dto.electric() != null && !dto.electric().isBlank()) {
            bike.setElectric(dto.electric());
        }
        if(dto.discBrakes() != null && !dto.discBrakes().isBlank()) {
            bike.setDiscBrakes(dto.discBrakes());
        }
        Bike saved = bikeRepository.save(bike);
        return bikeMapper.toBikeResponseDto(saved);

    }

    private void check(BikeRequestDto dto) {
        if (dto == null)
            throw new BikeException(messages.getMessage("bike.null"));

    }
}