package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.model.ServiceManagement;
import com.example.hotelmanagement.service.ServiceManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("serviceManagement")
public class ServiceManagementController {
    private final ServiceManagementService serviceManagementService;

    public ServiceManagementController(ServiceManagementService serviceManagementService) {
        this.serviceManagementService = serviceManagementService;
    }

    @PostMapping
    public ResponseEntity<ServiceManagement> createServiceManagement(@RequestBody ServiceManagement serviceManagement) {
        ServiceManagement createdServiceManagement = serviceManagementService.createServiceManagement(serviceManagement);
        return new ResponseEntity<>(createdServiceManagement, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceManagement>> getAllServiceManagements() {
        List<ServiceManagement> serviceManagements = serviceManagementService.getAllServiceManagement();
        return new ResponseEntity<>(serviceManagements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceManagement> getServiceManagementById(@PathVariable("id") Long id) {
        ServiceManagement serviceManagement = serviceManagementService.getServiceManagementById(id);
        if (serviceManagement != null) {
            return new ResponseEntity<>(serviceManagement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceManagement> updateServiceManagement(@PathVariable("id") Long id, @RequestBody ServiceManagement serviceManagement) {
        ServiceManagement updatedServiceManagement = serviceManagementService.updateServiceManagement(id, serviceManagement);
        if (updatedServiceManagement != null) {
            return new ResponseEntity<>(updatedServiceManagement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceManagement> deleteServiceManagement(@PathVariable("id") Long id) {
        serviceManagementService.deleteServiceManagementById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
