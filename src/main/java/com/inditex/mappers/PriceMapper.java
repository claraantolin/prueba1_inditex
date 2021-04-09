package com.inditex.mappers;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.inditex.dtos.PriceDto;
import com.inditex.entities.Prices;

@Mapper(componentModel = "spring")
public interface PriceMapper {

	PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

	PriceDto toDTO(Prices price, LocalDateTime date);

}
