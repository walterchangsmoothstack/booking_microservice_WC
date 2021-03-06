package com.ss.utopia.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.api.dao.FlightBookingsRepository;
import com.ss.utopia.api.dao.FlightRepository;
import com.ss.utopia.api.pojo.Booking;
import com.ss.utopia.api.pojo.Flight;
import com.ss.utopia.api.pojo.FlightBookings;

@Service
public class FlightBookingService {

	@Autowired
	FlightBookingsRepository flight_bookings_repository;

	@Autowired
	FlightRepository flight_repository;

	// Helper used to link users -> bookings -> flights
	public List<Flight> getFlightByBookingId(List<Booking> bookings) {

		return bookings.stream().map(x -> flight_repository.getFlightByBooking(x.getId())).collect(Collectors.toList());

	}

	public FlightBookings update(FlightBookings flight_bookings) {

		return flight_bookings_repository.save(flight_bookings);

	}

}
