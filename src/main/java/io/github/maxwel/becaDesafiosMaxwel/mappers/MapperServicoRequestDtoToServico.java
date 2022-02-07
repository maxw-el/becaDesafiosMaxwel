package io.github.maxwel.becaDesafiosMaxwel.mappers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.ServicoRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperServicoRequestDtoToServico {

        public Servico toDomain(ServicoRequestDto servicoRequestDto);
}
