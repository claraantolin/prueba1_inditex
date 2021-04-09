package com.inditex.mapper;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.inditex.dto.PriceDto;
import com.inditex.entity.Prices;

@Mapper(componentModel = "spring")
public interface PriceMapper {

	PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

	PriceDto toDTO(Prices price, LocalDateTime date);

}
