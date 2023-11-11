package com.management.repository;

import com.management.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;


@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {
    @Query(value = "FROM Orders o WHERE o.orderid=:orderid AND o.email_address=:email")
    public Orders findOrderByOrderIdAndEmail(@Param("orderid") String orderid, @Param("email") String email);
    
    @Query(value = "FROM Orders o WHERE o.id=:orderid")
    public Orders findOrderById(@Param("orderid") Integer orderid);
}