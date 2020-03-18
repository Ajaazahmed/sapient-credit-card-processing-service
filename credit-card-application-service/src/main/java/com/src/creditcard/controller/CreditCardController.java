package com.src.creditcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.src.creditcard.jpa.entity.CreditCard;
import com.src.creditcard.model.CreditCardRequest;
import com.src.creditcard.repository.CreditCardRepository;
import com.src.creditcard.service.CreditCardValidationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CreditCardController {

    private CreditCardRepository creditCardRepository;
    private CreditCardValidationService validationService;
    
    @Autowired
    private Environment env;

    @Autowired
    public CreditCardController(CreditCardRepository creditCardRepository, CreditCardValidationService validationService) {
        this.creditCardRepository = creditCardRepository;
        this.validationService = validationService;
    }
    
    //test cases
    //documentation

    @RequestMapping(method = RequestMethod.POST, value = "/creditcard/add")
    @ResponseBody
    public ResponseEntity addCreditCard(@RequestBody CreditCardRequest creditCardRequest) {
    	log.info("Request for adding card details for user {} and cardnumber {}", creditCardRequest.getName(), creditCardRequest.getCardNumber());
    	
    	if(validationService.isValidLuhnNumber(creditCardRequest.getCardNumber())) {
    		CreditCard cardDetails = new CreditCard();
    		cardDetails.setCardLimit(Integer.parseInt(creditCardRequest.getLimit()));
    		cardDetails.setCardName(creditCardRequest.getName());
    		cardDetails.setCardNumber(Long.parseLong(creditCardRequest.getCardNumber()));
    		creditCardRepository.save(cardDetails);
    		return ResponseEntity.ok("Card Saved Successfully");
    	}
    
    	return new ResponseEntity<>("Invalid Credit Card Number",HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/creditcard/getAll")
    @ResponseBody
    public ResponseEntity getCreditCardDetails() {   
    	log.info("Fetch all the Credit card details");
    	return ResponseEntity.ok(creditCardRepository.findAll());
    }
    
    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurerAdapter() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(env.getProperty("ALLOWED_ORIGIN")).allowedMethods("HEAD", "GET",
						"PUT", "POST", "DELETE", "PATCH");
				;
                super.addCorsMappings(registry);
            }

        };
    }
}
