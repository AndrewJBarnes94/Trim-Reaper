package com.brocodesoftware.trimreaper;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
	Quote findByQuoteNumber(String quoteNumber);
}
