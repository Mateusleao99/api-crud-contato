package com.crud.dto;

import org.modelmapper.ModelMapper;

import com.crud.domain.Favorecido;

public class FavorecidoDTO extends Favorecido {
	
	public static FavorecidoDTO create(Favorecido favorecido) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(favorecido, FavorecidoDTO.class);
	}

}
