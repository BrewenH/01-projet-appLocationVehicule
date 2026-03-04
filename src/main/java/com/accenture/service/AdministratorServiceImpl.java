package com.accenture.service;

import com.accenture.exception.AdministratorException;
import com.accenture.models.Administrator;
import com.accenture.repository.AdministratorRepository;
import com.accenture.service.dto.AdministratorRequestDto;
import com.accenture.service.dto.AdministratorResponseDto;
import com.accenture.service.mapper.AdministratorMapper;
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
public class AdministratorServiceImpl implements AdministratorService{

    private static final String ADMIN_NOT_FOUND = "administrator.id.notfound";

    private final AdministratorRepository administratorRepository;
    private final AdministratorMapper administratorMapper;
    private final MessageSourceAccessor messages;

    @Override
    public void addAdministrator(AdministratorRequestDto dto) throws AdministratorException {
        check(dto);
        Administrator administrator = administratorMapper.toAdministrator(dto);
        administratorRepository.save(administrator);
    }

    @Override
    public List<AdministratorResponseDto> findAll() {
        return administratorRepository.findAll().stream()
                .map(administratorMapper::toAdministratorResponseDto)
                .toList();
    }

    @Override
    public AdministratorResponseDto findById(UUID id) {
        Optional<Administrator> opt = administratorRepository.findById(id);
        if(opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage(ADMIN_NOT_FOUND));
        return administratorMapper.toAdministratorResponseDto(opt.get());
    }

    @Override
    public void deleteAdministrator(UUID id) {
        if (!administratorRepository.existsById(id))
            throw new EntityNotFoundException(messages.getMessage(ADMIN_NOT_FOUND));
        administratorRepository.deleteById(id);
    }

    @Override
    public AdministratorResponseDto modifyAdministrator(UUID id, AdministratorRequestDto dto) {
        return null;
    }

    private void check(AdministratorRequestDto dto) {
        if (dto == null)
            throw new AdministratorException(messages.getMessage("administrator.null"));
    }
}
