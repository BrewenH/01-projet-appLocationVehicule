package com.accenture.controller.impl;

import com.accenture.controller.ClientApi;
import com.accenture.service.ClientService;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class ClientController implements ClientApi {

    private final ClientService clientService;



    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Override
    public ResponseEntity<List<ClientResponseDto>> getAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PreAuthorize("hasAnyAuthority('CLIENT', 'ADMINISTRATOR')")
    @Override
    public ResponseEntity<ClientResponseDto> getById(UUID id) {
        return ResponseEntity.ok(clientService.findById(id));
    }


    @Override
    public ResponseEntity<Void> add(@Valid ClientRequestDto requestDto) {
        ClientResponseDto clientResponseDto = clientService.addClient(requestDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientResponseDto.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasAnyAuthority('CLIENT', 'ADMINISTRATOR')")
    @Override
    public ResponseEntity<Void> delete(UUID id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyAuthority('CLIENT', 'ADMINISTRATOR')")
    @Override
    public ResponseEntity<ClientResponseDto> put(UUID id, @Valid ClientRequestDto requestDto) {
        ClientResponseDto responseDto = clientService.modifyClient(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
