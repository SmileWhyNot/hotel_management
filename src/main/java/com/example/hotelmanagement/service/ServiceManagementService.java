package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.ServiceManagement;
import com.example.hotelmanagement.repository.ServiceManagementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceManagementService {
    private final ServiceManagementRepository serviceManagementRepository;

    public ServiceManagementService(ServiceManagementRepository serviceManagementRepository) {
        this.serviceManagementRepository = serviceManagementRepository;
    }
    public ServiceManagement createServiceManagement(ServiceManagement serviceManagement){
        return serviceManagementRepository.save(serviceManagement);
    }

    public List<ServiceManagement> getAllServiceManagement() {
        return serviceManagementRepository.findAll();
    }

    public ServiceManagement getServiceManagementById(Long serviceManagementId) {
        return serviceManagementRepository.findById(serviceManagementId).orElse(null);
    }

    public ServiceManagement updayeServiceManagement(ServiceManagement serviceManagement){
        return serviceManagementRepository.save(serviceManagement);
    }

    public void deleteServiceManagementById(Long serviceManagementId) {
        serviceManagementRepository.deleteById(serviceManagementId);
    }


}
