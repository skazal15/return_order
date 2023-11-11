package com.management.repository;

import com.management.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
    @Query(value = "FROM Item i WHERE i.id = ?1")
    public Item findById(int id);
}