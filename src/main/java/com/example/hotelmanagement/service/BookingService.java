package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Booking;
import com.example.hotelmanagement.model.Client;
import com.example.hotelmanagement.model.Room;
import com.example.hotelmanagement.repository.BookingRepository;
import com.example.hotelmanagement.repository.ClientRepository;
import com.example.hotelmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository, ClientRepository clientRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
        this.roomRepository = roomRepository;
    }

    public Booking createBooking(Booking booking) {
        Long clientId = booking.getClient().getId();
        Client client = clientRepository.findById(clientId).orElse(null);
        Long roomId = booking.getRoom().getId();
        Room room = roomRepository.findById(roomId).orElse(null);

        if (client != null && room != null) {
            booking.setRoom(room);
            booking.setClient(client);
            return bookingRepository.save(booking);
        } else {
            return null;
        }
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long hotelId) {
        return bookingRepository.findById(hotelId).orElse(null);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking != null) {
            existingBooking.setStartDate(updatedBooking.getStartDate());
            existingBooking.setEndDate(updatedBooking.getEndDate());
            existingBooking.setBookingStatus(updatedBooking.getBookingStatus());
            existingBooking.setClient(updatedBooking.getClient());
            existingBooking.setRoom(updatedBooking.getRoom());
            existingBooking.setGuestCount(updatedBooking.getGuestCount());
            existingBooking.setAdditionalRequirements(updatedBooking.getAdditionalRequirements());
            return bookingRepository.save(existingBooking);
        } else {
            return null;
        }
    }

    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

}
