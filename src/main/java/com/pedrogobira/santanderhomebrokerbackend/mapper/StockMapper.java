package com.pedrogobira.santanderhomebrokerbackend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pedrogobira.santanderhomebrokerbackend.model.Stock;
import com.pedrogobira.santanderhomebrokerbackend.model.dto.StockDTO;

@Component
public class StockMapper {

	public Stock toEntity(StockDTO dto) {
		Stock stock = new Stock();
		stock.setId(dto.getId());
		stock.setName(dto.getName());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		stock.setDate(dto.getDate());
		return stock;
	}

	public StockDTO toDTO(Stock stock) {
		StockDTO dto = new StockDTO();
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		dto.setDate(stock.getDate());
		return dto;
	}

	public List<StockDTO> toDTO(List<Stock> listStock) {
		return listStock.stream().map(stock -> this.toDTO(stock)).collect(Collectors.toList());
	}

}
