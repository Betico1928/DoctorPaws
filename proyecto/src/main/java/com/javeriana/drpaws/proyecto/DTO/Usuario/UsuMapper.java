package com.javeriana.drpaws.proyecto.DTO.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.javeriana.drpaws.proyecto.entidad.Usuario;

@Mapper
public interface UsuMapper {
    UsuMapper INSTANCE = Mappers.getMapper(UsuMapper.class);

    UsuDTO convert(Usuario usuario);
}
