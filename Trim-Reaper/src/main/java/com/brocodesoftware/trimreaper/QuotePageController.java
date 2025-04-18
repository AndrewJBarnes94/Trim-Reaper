package com.brocodesoftware.trimreaper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuotePageController {

    @GetMapping("/quote/{id}")
    public String serveQuotePage() {
        return "forward:/quote.html";
    }
}
