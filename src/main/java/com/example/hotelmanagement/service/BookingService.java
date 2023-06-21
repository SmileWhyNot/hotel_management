package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Booking;
import com.example.hotelmanagement.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long hotelId){
        return bookingRepository.findById(hotelId).orElse(null);
    }

    public Booking updateBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

}
