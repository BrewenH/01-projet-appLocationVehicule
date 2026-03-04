package com.accenture.service;

import com.accenture.exception.MotorbikeException;
import com.accenture.models.Motorbike;
import com.accenture.repository.MotorbikeRepository;
import com.accenture.service.dto.MotorbikeRequestDto;
import com.accenture.service.dto.MotorbikeResponseDto;
import com.accenture.service.mapper.MotorbikeMapper;
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
public class MotorbikeServiceImpl implements MotorbikeService{

    private static final String MOTORBIKE_NOT_FOUND = "motobike.id.notfound";

    private final MotorbikeRepository motorbikeRepository;
    private final MotorbikeMapper motorbikeMapper;
    private final MessageSourceAccessor messages;

    @Override
    public void addMotorbike(MotorbikeRequestDto dto) throws MotorbikeException {
        check(dto);
        Motorbike motorbike = motorbikeMapper.toMotorbike(dto);
        motorbikeRepository.save(motorbike);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MotorbikeResponseDto> findAll() {
        return motorbikeRepository.findAll().stream()
                .map(motorbikeMapper::toMotorbikeResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MotorbikeResponseDto findById(int id) {
        Optional<Motorbike> opt = motorbikeRepository.findById(id);
        if(opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage(MOTORBIKE_NOT_FOUND));
        return motorbikeMapper.toMotorbikeResponseDto(opt.get());
    }

    @Override
    public void deleteMotorbike(int id) {
        if(!motorbikeRepository.existsById(id))
            throw new EntityNotFoundException(messages.getMessage(MOTORBIKE_NOT_FOUND));
        motorbikeRepository.deleteById(id);
    }

    @Override
    public MotorbikeResponseDto modifyMotorbike(int id, MotorbikeRequestDto dto) {
        Motorbike motorbike = motorbikeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(MOTORBIKE_NOT_FOUND)));
        check(dto);
        motorbike.setBrand(dto.brand());
        motorbike.setModel(dto.model());
        motorbike.setType(dto.type());
        motorbike.setColor(dto.color());
        motorbike.setLicense(dto.license());
        motorbike.setMileage(dto.mileage());
        motorbike.setDailyBaseRate(dto.dailyBaseRate());
        motorbike.setActive(dto.active());
        motorbike.setRemovedFromPark(dto.removedFromPark());
        motorbike.setNumberOfCylinder(dto.numberOfCylinder());
        motorbike.setEngineDisplacement(dto.engineDisplacement());
        motorbike.setWeight(dto.weight());
        motorbike.setKWPower(dto.kWPower());
        motorbike.setSeatHeight(dto.seatHeight());
        motorbike.setTransmission(dto.transmission());
        Motorbike saved = motorbikeRepository.save(motorbike);
        return motorbikeMapper.toMotorbikeResponseDto(saved);
    }

    @Override
    public MotorbikeResponseDto partiallyModifyingMotorbike(int id, MotorbikeRequestDto dto) {
        Motorbike motorbike = motorbikeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(MOTORBIKE_NOT_FOUND)));
        if (dto.brand() != null && !dto.brand().isBlank()) {
            motorbike.setBrand(dto.brand());
        }
        if (dto.model() != null && !dto.model().isBlank()) {
            motorbike.setModel(dto.model());
        }
        if (dto.type() != null && !dto.type().isBlank()) {
            motorbike.setType(dto.type());
        }
        if (dto.color() != null && !dto.color().isBlank()) {
            motorbike.setColor(dto.color());
        }
        if (dto.license() != null && !dto.license().isBlank()) {
            motorbike.setLicense(dto.license());
        }
        if (dto.mileage() < 0) {
            motorbike.setMileage(dto.mileage());
        }
        if (dto.dailyBaseRate() < 0) {
            motorbike.setDailyBaseRate(dto.dailyBaseRate());
        }

            motorbike.setActive(dto.active());


            motorbike.setRemovedFromPark(dto.removedFromPark());

        if (dto.numberOfCylinder() < 0) {
            motorbike.setNumberOfCylinder(dto.numberOfCylinder());
        }
        if (dto.engineDisplacement() < 0) {
            motorbike.setEngineDisplacement(dto.engineDisplacement());
        }
        if (dto.weight() < 0) {
            motorbike.setWeight(dto.weight());
        }
        if (dto.kWPower() < 0) {
            motorbike.setKWPower(dto.kWPower());
        }
        if (dto.seatHeight() < 0) {
            motorbike.setSeatHeight(dto.seatHeight());
        }
        if (dto.transmission() != null && !dto.transmission().isBlank()) {
            motorbike.setTransmission(dto.transmission());
        }
        Motorbike saved = motorbikeRepository.save(motorbike);
        return motorbikeMapper.toMotorbikeResponseDto(saved);
    }

    private void check(MotorbikeRequestDto dto) {
        if(dto == null)
            throw new MotorbikeException(messages.getMessage("motorbike.null"));
    }
}
