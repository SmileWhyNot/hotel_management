package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Hotel;
import com.example.hotelmanagement.model.Room;
import com.example.hotelmanagement.repository.HotelRepository;
import com.example.hotelmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public Room createRoom(Room room) {
        Long hotelId = room.getHotel().getId();
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
        if (hotel != null) {
            room.setHotel(hotel);
            return roomRepository.save(room);
        } else {
            return null;
        }
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    public Room updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id).orElse(null);
        if (existingRoom != null) {
            existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
            existingRoom.setRoomType(updatedRoom.getRoomType());
            existingRoom.setAvailability(updatedRoom.getAvailability());
            existingRoom.setHotel(updatedRoom.getHotel());
            existingRoom.setPrice(updatedRoom.getPrice());
            existingRoom.setBedCount(updatedRoom.getBedCount());
            return roomRepository.save(existingRoom);
        }else {
            return null;
        }
    }

    public void deleteRoomById(Long roomId){
        roomRepository.deleteById(roomId);
    }
}
