package com.example.lab.dataAccess;

import com.example.lab.entity.concretes.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaborantRepository extends JpaRepository <Laborant, Long> {

}
