package com.jit.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jit.boot.model.StockQuote;


public interface StockQuoteRepository
	extends JpaRepository<StockQuote, Integer>{

}
