package com.accenture.service;

import com.accenture.exception.ClientException;
import com.accenture.models.Client;
import com.accenture.repository.ClientRepository;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import com.accenture.service.mapper.ClientMapper;
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
public class ClientServiceImpl implements ClientService{

    private static final String CLIENT_NOT_FOUND = "client.id.notfound";

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final MessageSourceAccessor messages;

    @Override
    public void addClient(ClientRequestDto dto) throws ClientException {
        check(dto);
        Client client = clientMapper.toClient(dto);
        clientRepository.save(client);
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toClientResponseDto)
                .toList();
    }

    @Override
    public ClientResponseDto findById(UUID id) {
        Optional<Client> opt = clientRepository.findById(id);
        if (opt.isEmpty())
            throw new EntityNotFoundException(messages.getMessage(CLIENT_NOT_FOUND));
        return clientMapper.toClientResponseDto(opt.get());


    }

    @Override
    public void deleteClient(UUID id) {
        if (!clientRepository.existsById(id))
            throw new EntityNotFoundException(messages.getMessage(CLIENT_NOT_FOUND));
        clientRepository.deleteById(id);
    }

    @Override
    public ClientResponseDto modifyClient(UUID id, ClientRequestDto dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(messages.getMessage(CLIENT_NOT_FOUND)));
        check(dto);
        client.setLastName(dto.lastName());
        client.setFirstName(dto.firstName());
        client.setEmail(dto.email());
        client.setPassword(dto.password());
        client.setBirthDate(dto.birthDate());
        client.setRegistrationDate(dto.registrationDate());
        client.setLicenseList(dto.licenseList());
        client.setDesactivated(dto.desactivated());
        Client saved = clientRepository.save(client);
        return clientMapper.toClientResponseDto(saved);
    }

    private void check(ClientRequestDto dto) {
        if (dto == null)
            throw new ClientException(messages.getMessage("client.null"));
    }
}
