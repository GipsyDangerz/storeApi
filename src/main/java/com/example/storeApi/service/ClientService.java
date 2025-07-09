package com.example.storeApi.service;

import com.example.storeApi.model.Client;
import com.example.storeApi.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client updateClient(Long id, String name, String gender, Integer age) {
        Client client = findById(id);
        client.setName(name);
        client.setAge(age);
        client.setGender(gender);
        return clientRepository.save(client);
    }
}
