package com.example.lab.dataAccess;

import com.example.lab.entity.concretes.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {

}
