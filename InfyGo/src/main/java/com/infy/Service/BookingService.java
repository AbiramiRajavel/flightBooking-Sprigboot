package com.infy.Service;


import java.util.Set;

import com.infy.Dto.CreditcardDetailsDTO;
import com.infy.Dto.PassengerDetailsDTO;

public interface BookingService {
    public String bookTickets(String flightId,String userId,Set<PassengerDetailsDTO> passengerDetails);
    public String payment(CreditcardDetailsDTO creditCardDto);
}
