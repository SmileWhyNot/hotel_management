package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Hotel;
import com.example.hotelmanagement.model.ServiceCategory;
import com.example.hotelmanagement.model.ServiceManagement;
import com.example.hotelmanagement.repository.HotelRepository;
import com.example.hotelmanagement.repository.ServiceCategoryRepository;
import com.example.hotelmanagement.repository.ServiceManagementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceManagementService {
    private final ServiceManagementRepository serviceManagementRepository;
    private final HotelRepository hotelRepository;
    private final ServiceCategoryRepository serviceCategoryRepository;

    public ServiceManagementService(ServiceManagementRepository serviceManagementRepository, HotelRepository hotelRepository, ServiceCategoryRepository serviceCategoryRepository) {
        this.serviceManagementRepository = serviceManagementRepository;
        this.hotelRepository = hotelRepository;
        this.serviceCategoryRepository = serviceCategoryRepository;
    }

    public ServiceManagement createServiceManagement(ServiceManagement serviceManagement) {
        Long hotelId = serviceManagement.getHotel().getId();
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
        Long serviceCategoryId = serviceManagement.getService().getId();
        ServiceCategory serviceCategory = serviceCategoryRepository.findById(serviceCategoryId).orElse(null);

        if (serviceCategory != null && hotel != null) {
            serviceManagement.setService(serviceCategory);
            serviceManagement.setHotel(hotel);
            return serviceManagementRepository.save(serviceManagement);
        } else {
            return null;
        }
    }

    public List<ServiceManagement> getAllServiceManagement() {
        return serviceManagementRepository.findAll();
    }

    public ServiceManagement getServiceManagementById(Long serviceManagementId) {
        return serviceManagementRepository.findById(serviceManagementId).orElse(null);
    }

    public ServiceManagement updateServiceManagement(Long id, ServiceManagement updatedServiceManagement) {
        ServiceManagement existingServiceManagement = serviceManagementRepository.findById(id).orElse(null);
        if (existingServiceManagement != null) {
            existingServiceManagement.setHotel(updatedServiceManagement.getHotel());
            existingServiceManagement.setService(updatedServiceManagement.getService());
            return serviceManagementRepository.save(existingServiceManagement);
        } else {
            return null;
        }

    }

    public void deleteServiceManagementById(Long serviceManagementId) {
        serviceManagementRepository.deleteById(serviceManagementId);
    }


}
