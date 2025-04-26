package com.inn.kafkatask.consumerspringboot.dao;

import com.inn.kafkatask.consumerspringboot.entity.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderTable, String> {
}
