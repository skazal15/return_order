package com.management.repository;

import java.util.List;

import com.management.model.Returns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ReturnRepo extends JpaRepository<Returns, Integer>{
    @Query(value = "FROM Returns r WHERE r.token = ?1")
    public Returns findReturnsObjectByToken(String token);
    
    @Query(value = "From Returns r WHERE r.orderid = ?1")
    public Returns findReturnsObjectByOrderId(int orderid);

    @Query(value = "From Returns r WHERE r.orderid = ?1")
    public List<Returns> findAllReturnsObjectByOrderId(int orderid);

    @Query(value = "From Returns r WHERE r.id = ?1")
    public Returns findReturnsObjectById(int id);

    @Query(value = "From Returns r WHERE r.id = ?1 AND r.item_id=?2")
    public Returns findReturnsObjectByIdAndItemId(int id,int item_id);
    
}