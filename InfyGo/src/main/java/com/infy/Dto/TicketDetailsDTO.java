package com.infy.Dto;

import java.sql.Date;

import com.infy.Entity.FlightDetails;
import com.infy.Entity.UserDetails;

public class TicketDetailsDTO {
	private Integer pnr;
	private Date bookingDate;
	private Date departureDate;
	private String departureTime;
    private FlightDetails flight; 
	private Integer noOfSeats;
	private Double totalFare;
	private UserDetails user;
	
	public TicketDetailsDTO() {
		super();
	}
	public TicketDetailsDTO(Integer pnr, Date bookingDate, Date departureDate, String departureTime,
			FlightDetails flight, Integer noOfSeats, Double totalFare, UserDetails user) {
		super();
		this.pnr = pnr;
		this.bookingDate = bookingDate;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.flight = flight;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
		this.user = user;
	}
	public Integer getPnr() {
		return pnr;
	}
	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public FlightDetails getFlight() {
		return flight;
	}
	public void setFlight(FlightDetails flight) {
		this.flight = flight;
	}
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public Double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
}
