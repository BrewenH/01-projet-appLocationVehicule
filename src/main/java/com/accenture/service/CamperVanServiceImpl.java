package com.accenture.service;
import com.accenture.exception.CamperVanException;
import com.accenture.models.CamperVan;
import com.accenture.repository.CamperVanRepository;
import com.accenture.service.dto.CamperVanRequestDto;
import com.accenture.service.dto.CamperVanResponseDto;
import com.accenture.service.mapper.CamperVanMapper;
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
public class CamperVanServiceImpl implements CamperVanService{

    private static final String CAMPERVAN_NOT_FOUND = "campervan.id.notfound";

    private final CamperVanRepository camperVanRepository;
    private final CamperVanMapper camperVanMapper;
    private final MessageSourceAccessor messages;

    @Override
    public void addCamperVan(CamperVanRequestDto dto) throws CamperVanException {
        check(dto);
        CamperVan camperVan = camperVanMapper.toCamperVan(dto);
        camperVanRepository.save(camperVan);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CamperVanResponseDto> findAll() {
        return camperVanRepository.findAll().stream()
                .map(camperVanMapper::toCamperVanResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CamperVanResponseDto findById(int id) {
        Optional<CamperVan> opt = camperVanRepository.findById(id);
        if (opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage(CAMPERVAN_NOT_FOUND));
        return camperVanMapper.toCamperVanResponseDto(opt.get());
    }

    @Override
    public void deleteCamperVan(int id) {
        if (!camperVanRepository.existsById(id))
            throw new EntityNotFoundException(messages.getMessage(CAMPERVAN_NOT_FOUND));
        camperVanRepository.deleteById(id);
    }
    @Override
    public CamperVanResponseDto modifyCamperVan(int id, CamperVanRequestDto dto) throws CamperVanException {
        CamperVan camperVan = camperVanRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(CAMPERVAN_NOT_FOUND)));
        check(dto);
        camperVan.setBrand(dto.brand());
        camperVan.setModel(dto.model());
        camperVan.setType(dto.type());
        camperVan.setColor(dto.color());
        camperVan.setLicense(dto.license());
        camperVan.setMileage(dto.mileage());
        camperVan.setDailyBaseRate(dto.dailyBaseRate());
        camperVan.setActive(dto.active());
        camperVan.setRemovedFromPark(dto.removedFromPark());
        camperVan.setNumberOfSeats(dto.numberOfSeats());
        camperVan.setEnergySources(dto.energySources());
        camperVan.setTransmission(dto.transmission());
        camperVan.setAirConditioning(dto.airConditioning());
        camperVan.setWeight(dto.weight());
        camperVan.setHeight(dto.height());
        camperVan.setNumberOfBeds(dto.numberOfBeds());
        camperVan.setKitchenEquipment(dto.kitchenEquipment());
        camperVan.setBedLinens(dto.bedLinens());
        camperVan.setRefrigeratorEquipment(dto.refrigeratorEquipment());
        camperVan.setShowerEquipment(dto.showerEquipment());
        CamperVan saved = camperVanRepository.save(camperVan);
        return camperVanMapper.toCamperVanResponseDto(saved);
    }

    @Override
    public CamperVanResponseDto partiallyModifyingCamperVan(int id, CamperVanRequestDto dto) {
        CamperVan camperVan = camperVanRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(CAMPERVAN_NOT_FOUND)));
        if(dto.brand() != null && !dto.brand().isBlank()) {
            camperVan.setBrand(dto.brand());
        }
        if(dto.model() != null && !dto.model().isBlank()) {
            camperVan.setModel(dto.model());
        }
        if(dto.type() != null && !dto.type().isBlank()) {
            camperVan.setType(dto.type());
        }
        if(dto.color() != null && !dto.color().isBlank()) {
            camperVan.setColor(dto.color());
        }
        if(dto.license() != null && !dto.license().isBlank()) {
            camperVan.setLicense(dto.license());
        }
        if(dto.mileage() < 0) {
            camperVan.setMileage(dto.mileage());
        }
        if(dto.dailyBaseRate() < 0) {
            camperVan.setDailyBaseRate(dto.dailyBaseRate());
        }
        if(dto.numberOfSeats() < 0) {
            camperVan.setNumberOfSeats(dto.numberOfSeats());
        }
        if(dto.energySources() != null && !dto.energySources().isBlank()) {
            camperVan.setEnergySources(dto.energySources());
        }
        if(dto.transmission() != null && !dto.transmission().isBlank()) {
            camperVan.setTransmission(dto.transmission());
        }

        if(dto.weight() < 0) {
            camperVan.setWeight(dto.weight());
        }
        if(dto.height() < 0) {
            camperVan.setHeight(dto.height());
        }
        if(dto.numberOfBeds() < 0) {
            camperVan.setNumberOfBeds(dto.numberOfBeds());
        }
        camperVan.setActive(dto.active());
        camperVan.setRemovedFromPark(dto.removedFromPark());
        CamperVan saved = camperVanRepository.save(camperVan);
        return camperVanMapper.toCamperVanResponseDto(saved);

    }

    private void check(CamperVanRequestDto dto) {
        if (dto == null)
            throw new CamperVanException(messages.getMessage("camperVan.null"));

    }
}
