package com.example.storeApi.repository;

import com.example.storeApi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>  {
}
