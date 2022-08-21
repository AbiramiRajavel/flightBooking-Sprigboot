package com.infy.Entity;

import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TicketDetails 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pnr;
	private Date bookingDate;
	private Date departureDate;
	private String departureTime;
	
	@ManyToOne(targetEntity=FlightDetails.class,cascade=CascadeType.ALL)
	@JoinColumn(name="flightid")
	private FlightDetails flight;
	
	private Integer noOfSeats;
	private Double totalFare;
	
	@ManyToOne(targetEntity=UserDetails.class, cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private UserDetails user;
	
	@OneToMany(targetEntity=PassengerDetails.class,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="ticket_pnr")
	private Set<PassengerDetails> passengerDetails;
	
	public Set<PassengerDetails> getPassengerDetails() {
		return passengerDetails;
	}
	public void setPassengerDetails(Set<PassengerDetails> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	public TicketDetails() {
		super();
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
	public FlightDetails getFlight() {
		return flight;
	}
	public void setFlight(FlightDetails flight) {
		this.flight = flight;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	
}
