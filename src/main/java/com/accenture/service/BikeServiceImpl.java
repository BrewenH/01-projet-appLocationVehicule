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
            throw new EntityNotFoundException(messages.getMessage("bike.id.notfound"));
        return bikeMapper.toBikeResponseDto(opt.get());
    }

    @Override
    public void deleteBike(int id) {
        Optional<Bike> opt = bikeRepository.findById(id);
        if (opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage("bike.id.notfound"));
        else
            throw new BikeException(messages.getMessage("bike.vehicle.exist"));
    }

    @Override
    public BikeResponseDto modifyBike(int id, BikeRequestDto dto) {
        Optional<Bike> opt = bikeRepository.findById(id);
        if (opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage("bike.id.notfound"));
        check(dto);
        Bike bike = opt.get();
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
        return bikeMapper.toBikeResponseDto(bike);
    }

//    @Override
//    public BikeResponseDto partiallyModifying(int id, BikeRequestDto dto) {
//        Optional<Bike> opt = bikeRepository.findById(id);
//        if(opt.isEmpty())
//            throw new EntityNotFoundException(messages.getMessage("bike.id.notfound"));
//        Bike bike = opt.get();
//        if(dto.)
//    }

    private void check(BikeRequestDto dto) {
        if (dto == null)
            throw new BikeException(messages.getMessage("bike.null"));

    }
}