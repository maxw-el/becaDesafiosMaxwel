package io.github.maxwel.becaDesafiosMaxwel.mappers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.ClienteRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperClienteRequestDtoToCliente {

    public Cliente toDomain(ClienteRequestDto clienteRequestDto);
}
