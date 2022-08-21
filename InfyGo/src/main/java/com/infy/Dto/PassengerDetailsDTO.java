package com.infy.Dto;


public class PassengerDetailsDTO {
	private Integer passengerId;
	private String passenagerAge;
	private String passengerGender;
	private String passengerName;
	public PassengerDetailsDTO() {
		super();
	}
	public PassengerDetailsDTO(Integer passengerId, String passenagerAge, String passengerGender, String passengerName) {
	
		this.passengerId = passengerId;
		this.passenagerAge = passenagerAge;
		this.passengerGender = passengerGender;
		this.passengerName = passengerName;
	}
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassenagerAge() {
		return passenagerAge;
	}
	public void setPassenagerAge(String passenagerAge) {
		this.passenagerAge = passenagerAge;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

}
