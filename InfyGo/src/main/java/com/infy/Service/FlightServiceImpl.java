package com.infy.Service;

import java.sql.Date;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Dto.FlightDetailsDTO;
import com.infy.Entity.FlightDetails;
import com.infy.Repository.FlightRepository;
@Service
public class FlightServiceImpl implements FlightService {
   @Autowired
   private FlightRepository flightRepository;
   @Autowired
   private ModelMapper mapper;
   
   @Override
   public void add(FlightDetailsDTO flightDetailsdto) {
	FlightDetails flightDetails=mapper.map(flightDetailsdto, FlightDetails.class);
	int ranId=(int)Math.floor(Math.random()*10000+2*10);
	flightDetails.setFlightId(String.valueOf(ranId));
	flightRepository.save(flightDetails);
   }
   
   @Override
   public String getSource()
   {
	  List<FlightDetails> flightDetails= flightRepository.findAll();
	  String sources= flightDetails.stream().map(m->mapper.map(m, FlightDetailsDTO.class)).map(m->m.getSource()).collect(Collectors.joining(","));
	  return sources;
   }

   @Override
   public  String getDestination() {
	  List<FlightDetails> flightDetails=flightRepository.findAll();
	  List<FlightDetailsDTO> ls=flightDetails.stream().map(m->mapper.map(m, FlightDetailsDTO.class)).collect(Collectors.toList());
     String destinations=ls.stream().map(m->m.getDestination()).collect(Collectors.joining(","));
     return destinations;
   }

    @Override
    public List<FlightDetailsDTO> flightDetails(String source,String destination,String date) throws ParseException {
      Date d=Date.valueOf(date);      
	  List<FlightDetails> flightDetails=flightRepository.findFlightDetails(source,destination,d);
	  List<FlightDetailsDTO> ls=flightDetails.stream().map(m->mapper.map(m, FlightDetailsDTO.class)).collect(Collectors.toList());
      return ls;
    }


 
}
