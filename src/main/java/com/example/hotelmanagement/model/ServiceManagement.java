package com.example.hotelmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "service_management")
public class ServiceManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceCategory service;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ServiceCategory getService() {
        return service;
    }

    public void setService(ServiceCategory service) {
        this.service = service;
    }
}
