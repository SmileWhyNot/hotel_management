package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Hotel;
import com.example.hotelmanagement.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId).orElse(null);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Hotel existingHotel = hotelRepository.findById(id).orElse(null);
        if (existingHotel != null) {
            existingHotel.setName(updatedHotel.getName());
            existingHotel.setAddress(updatedHotel.getAddress());
            existingHotel.setRating(updatedHotel.getRating());
            existingHotel.setRoomCount(updatedHotel.getRoomCount());
            existingHotel.setPhoneNumber(updatedHotel.getPhoneNumber());
            return hotelRepository.save(existingHotel);
        } else {
            return null;
        }
    }

    public void deleteHotelById(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
