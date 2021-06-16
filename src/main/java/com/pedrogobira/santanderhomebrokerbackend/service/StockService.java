package com.pedrogobira.santanderhomebrokerbackend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pedrogobira.santanderhomebrokerbackend.exceptions.BusinessException;
import com.pedrogobira.santanderhomebrokerbackend.exceptions.NotFoundException;
import com.pedrogobira.santanderhomebrokerbackend.mapper.StockMapper;
import com.pedrogobira.santanderhomebrokerbackend.model.Stock;
import com.pedrogobira.santanderhomebrokerbackend.model.dto.StockDTO;
import com.pedrogobira.santanderhomebrokerbackend.repository.StockRepository;
import com.pedrogobira.santanderhomebrokerbackend.util.MessageUtils;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	@Autowired
	private StockMapper mapper;

	@Transactional
	public StockDTO save(StockDTO dto) {
		Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
		if (optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}

		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDTO(stock);
	}

	@Transactional
	public StockDTO update(StockDTO dto) {
		Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getId(), dto.getName(), dto.getDate());
		if (optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDTO(stock);
	}

	@Transactional
	public StockDTO delete(Long id) {
		StockDTO dto = this.findById(id);
		repository.deleteById(dto.getId());
		return dto;
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findAll() {
		return mapper.toDTO(repository.findAll());
	}

	@Transactional(readOnly = true)
	public StockDTO findById(Long id) {
		return repository.findById(id).map(stock -> mapper.toDTO(stock)).orElseThrow(NotFoundException::new);
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findByToday() {
		return repository.findByToday(LocalDate.now()).map(stock -> mapper.toDTO(stock))
				.orElseThrow(NotFoundException::new);
	}

}
