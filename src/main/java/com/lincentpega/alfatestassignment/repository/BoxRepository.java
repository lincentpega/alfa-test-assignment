package com.lincentpega.alfatestassignment.repository;

import com.lincentpega.alfatestassignment.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BoxRepository extends JpaRepository<Box, Integer> {
}