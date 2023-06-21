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

    public ServiceCategory createServiceCategory(ServiceCategory serviceCategory){
        return serviceCategoryRepository.save(serviceCategory);
    }

    public List<ServiceCategory> getAllServiceCategories(){
        return serviceCategoryRepository.findAll();
    }

    public ServiceCategory getServiceCategoryById(Long serviceCategoryId){
        return serviceCategoryRepository.findById(serviceCategoryId).orElse(null);
    }

    public ServiceCategory updateServiceCategory(ServiceCategory serviceCategory){
        return serviceCategoryRepository.save(serviceCategory);
    }

    public void deleteServiceCategoryById(Long serviceCategoryId){
        serviceCategoryRepository.deleteById(serviceCategoryId);
    }
}
