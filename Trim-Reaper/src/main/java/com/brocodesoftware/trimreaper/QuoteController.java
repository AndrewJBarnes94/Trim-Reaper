package com.brocodesoftware.trimreaper;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
public ResponseEntity<String> receiveQuote(@RequestBody Quote quote) {
    quote.setQuoteNumber(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
    quote.setDateRequested(LocalDateTime.now());
    quote.setStatus("pending");

    System.out.println("Received requested services: " + quote.getRequestedServices()); // DEBUG

    quoteRepository.save(quote);

    emailService.sendQuoteEmail(quote.getEmail(), quote.getQuoteNumber(), quote.getId());

    return ResponseEntity.ok("Quote submitted");
}

	
	@GetMapping("/quote/{id}")
	public ResponseEntity<Quote> viewQuote(@PathVariable Long id) {
	    return quoteRepository.findById(id)
	        .map(ResponseEntity::ok)
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/quote/{id}/schedule")
	public ResponseEntity<?> scheduleQuote(@PathVariable Long id, @RequestBody Map<String, String> payload) {
		return quoteRepository.findById(id).map(quote -> {
			quote.setPreferredDays(payload.get("preferredDays"));
			quote.setPreferredTimes(payload.get("preferredTimes"));
			quote.setUrgency(payload.get("urgency"));
			quote.setStatus("awaiting_schedule");
			quoteRepository.save(quote);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}



}
