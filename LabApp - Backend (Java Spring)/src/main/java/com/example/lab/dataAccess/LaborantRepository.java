package com.example.lab.dataAccess;

import com.example.lab.entity.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LaborantRepository extends JpaRepository <Laborant, Long> {

}
