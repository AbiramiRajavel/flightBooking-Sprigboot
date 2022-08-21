package com.infy.Controller;


import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Dto.CreditcardDetailsDTO;
import com.infy.Dto.PassengerDetailsDTO;
import com.infy.Service.BookingService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;
    @PostMapping("book/{FlightId}/{UserId}")
    public ResponseEntity<String> bookingTicket(@PathVariable("FlightId")String flightId,@PathVariable("UserId") String userId,@RequestBody Set<PassengerDetailsDTO> passengerDetails){
    	String result= bookingService.bookTickets(flightId, userId, passengerDetails);
    	return new ResponseEntity<String>(result,HttpStatus.OK);
    }
    
    @PostMapping("/payment")
    public ResponseEntity<String> payment(@Valid @RequestBody CreditcardDetailsDTO creditCardDto){
    	return new ResponseEntity(bookingService.payment(creditCardDto),HttpStatus.ACCEPTED);
    }
    
  
}
