package com.infy.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Dto.CreditcardDetailsDTO;
import com.infy.Dto.PassengerDetailsDTO;
import com.infy.Entity.CreditcardDetails;
import com.infy.Entity.FlightDetails;
import com.infy.Entity.PassengerDetails;
import com.infy.Entity.TicketDetails;
import com.infy.Entity.UserDetails;
import com.infy.Repository.CerditCardRepository;
import com.infy.Repository.FlightRepository;
import com.infy.Repository.TicketRepository;
import com.infy.Repository.UserRepository;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    FlightRepository flightRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired 
	TicketRepository ticketRepository;
	@Autowired
	CerditCardRepository creditcardRepo;
	@Autowired
	ModelMapper mapper;
	@Override
	public String bookTickets(String flightId, String userId,Set<PassengerDetailsDTO> passengerDetailsdto) {
		Optional<FlightDetails> flightDetails=flightRepository.findById(flightId);
		Optional<UserDetails> userDetails=userRepository.findById(userId);
		Set<PassengerDetails> passengerDetails= passengerDetailsdto.stream().map(m->mapper.map(m, PassengerDetails.class)).collect(Collectors.toSet());
		if(flightDetails.isPresent()&&userDetails.isPresent())
		{
		    FlightDetails flight=flightDetails.get();
		    UserDetails user=userDetails.get();
		    int currentSeatCount=flight.getSeatCount();
		    int passengerCount=passengerDetailsdto.size();
		    if(currentSeatCount>=passengerCount) 
		    {
		      TicketDetails ticketDetails=new TicketDetails();
		      int ranId=(int)Math.floor(Math.random()*10000+9*10-2);
		      ticketDetails.setPnr(ranId);
		      Date bDate=Date.valueOf(LocalDate.now());
		      ticketDetails.setBookingDate(bDate);
		      Date date=Date.valueOf(LocalDate.now().plusDays(2));
		      ticketDetails.setDepartureDate(date);
		      ticketDetails.setDepartureTime("2pm");
		      ticketDetails.setFlight(flight);
		      ticketDetails.setNoOfSeats(passengerDetails.size());
		      double totalFare=flight.getFare()*passengerDetails.size();
		      ticketDetails.setTotalFare(totalFare);
		      ticketDetails.setUser(user);
		      ticketDetails.setPassengerDetails(passengerDetails);
		      ticketRepository.save(ticketDetails);
		      int updateSeatCount=currentSeatCount-passengerCount;
		      flightRepository.updateSeatCount(updateSeatCount, flightId);
		    }
		    else 
		    {
		    	return "Sorry seat is full!";
		    }
		}
		else
		{
			return "Wrong FlightId/userId";
		}
		return "Ticket booked successfully";
		
	}
	@Override
	public String payment(CreditcardDetailsDTO creditCardDto) {
		CreditcardDetails creditCard=mapper.map(creditCardDto, CreditcardDetails.class);
		int year=Integer.parseInt(creditCard.getExpiryYear());
		if(year>LocalDate.now().getYear())
		{
		creditcardRepo.save(creditCard);
		return "Payment Successful";
		}
		else {
			return "Expiry year must be Greater than the current year";
		}
	}

	

}
