package com.infy.Controller;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infy.Dto.FlightDetailsDTO;
import com.infy.Service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController
{
	@Autowired
	private FlightService flightService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> register(@RequestBody FlightDetailsDTO flightDetailsdto)
	{
		flightService.add(flightDetailsdto);
	     return new ResponseEntity<String>("Added Successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/sources")
	public ResponseEntity<String> flightSources()
	{
		String sources=flightService.getSource();
	   return new ResponseEntity(sources,HttpStatus.OK);
	}
	@GetMapping("/destinations")
	public ResponseEntity<String> flightDestination()
	{
		String destinations=flightService.getDestination();
		return new ResponseEntity(destinations,HttpStatus.OK);
	}
	@GetMapping("/{details}")
	public ResponseEntity<List<FlightDetailsDTO>> flightDetailsBasedOn(@MatrixVariable String source,@MatrixVariable String destination,@MatrixVariable String date) throws ParseException
	{
		List<FlightDetailsDTO> details=flightService.flightDetails( source,destination,date);
		return new ResponseEntity(details,HttpStatus.OK);
	}
	

}
