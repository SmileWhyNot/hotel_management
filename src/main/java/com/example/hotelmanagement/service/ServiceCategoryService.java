package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.ServiceCategory;
import com.example.hotelmanagement.repository.ServiceCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoryService {
    private final ServiceCategoryRepository serviceCategoryRepository;

    public ServiceCategoryService(ServiceCategoryRepository serviceCategoryRepository) {
        this.serviceCategoryRepository = serviceCategoryRepository;
    }

    public ServiceCategory createServiceCategory(ServiceCategory serviceCategory) {
        return serviceCategoryRepository.save(serviceCategory);
    }

    public List<ServiceCategory> getAllServiceCategories() {
        return serviceCategoryRepository.findAll();
    }

    public ServiceCategory getServiceCategoryById(Long serviceCategoryId) {
        return serviceCategoryRepository.findById(serviceCategoryId).orElse(null);
    }

    public ServiceCategory updateServiceCategory(Long id, ServiceCategory updatedServiceCategory) {
        ServiceCategory existingServiceCategory = serviceCategoryRepository.findById(id).orElse(null);
        if (existingServiceCategory != null) {
            existingServiceCategory.setCategory(updatedServiceCategory.getCategory());
            existingServiceCategory.setAvailability(updatedServiceCategory.isAvailability());
            existingServiceCategory.setName(updatedServiceCategory.getName());
            existingServiceCategory.setPrice(updatedServiceCategory.getPrice());
            existingServiceCategory.setDescription(updatedServiceCategory.getDescription());
            return serviceCategoryRepository.save(existingServiceCategory);
        } else {
            return null;
        }

    }

    public void deleteServiceCategoryById(Long serviceCategoryId) {
        serviceCategoryRepository.deleteById(serviceCategoryId);
    }
}
