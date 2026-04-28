package com.project.webservices.services;

import com.project.webservices.entities.Order;
import com.project.webservices.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public Order insert(Order order) {

        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new RuntimeException("Pedido não pode ser vazio");
        }

        return repository.save(order);
    }
}

