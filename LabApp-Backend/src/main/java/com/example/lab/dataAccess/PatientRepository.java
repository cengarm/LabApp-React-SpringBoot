package com.example.lab.dataAccess;

import com.example.lab.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient, Long> {
}
