package com.lincentpega.alfatestassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lincentpega.alfatestassignment.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}