package com.example.hotelmanagement.repository;

import com.example.hotelmanagement.model.ServiceManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceManagementRepository extends JpaRepository<ServiceManagement, Long> {
}
