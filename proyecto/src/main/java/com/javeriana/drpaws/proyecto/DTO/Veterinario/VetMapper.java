package com.javeriana.drpaws.proyecto.DTO.Veterinario;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.javeriana.drpaws.proyecto.entidad.Veterinario;

@Mapper
public interface VetMapper {
    VetMapper INSTANCE = Mappers.getMapper(VetMapper.class);

    VetDTO convert(Veterinario veterinario);
    
}
