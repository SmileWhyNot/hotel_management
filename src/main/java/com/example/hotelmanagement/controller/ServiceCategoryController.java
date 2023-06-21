package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.model.ServiceCategory;
import com.example.hotelmanagement.service.ServiceCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceCategoryController {
    private final ServiceCategoryService serviceCategoryService;

    public ServiceCategoryController(ServiceCategoryService serviceCategoryService) {
        this.serviceCategoryService = serviceCategoryService;
    }

    @PostMapping
    public ResponseEntity<ServiceCategory> createServiceCategory(@RequestBody ServiceCategory serviceCategory) {
        ServiceCategory createdServiceCategory = serviceCategoryService.createServiceCategory(serviceCategory);
        return new ResponseEntity<>(createdServiceCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceCategory>> getAllServiceCategories() {
        List<ServiceCategory> serviceCategories = serviceCategoryService.getAllServiceCategories();
        return new ResponseEntity<>(serviceCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCategory> getServiceCategoryById(@PathVariable("id") Long id) {
        ServiceCategory serviceCategory = serviceCategoryService.getServiceCategoryById(id);
        if (serviceCategory != null) {
            return new ResponseEntity<>(serviceCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceCategory> updateServiceCategory(@PathVariable("id") Long id, @RequestBody ServiceCategory serviceCategory) {
        ServiceCategory updatedServiceCategory = serviceCategoryService.updateServiceCategory(id, serviceCategory);
        if (updatedServiceCategory != null) {
            return new ResponseEntity<>(updatedServiceCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceCategory> deleteServiceCategory(@PathVariable("id") Long id) {
        serviceCategoryService.deleteServiceCategoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
