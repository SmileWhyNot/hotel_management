package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Client;
import com.example.hotelmanagement.repository.ClientRepository;
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

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    public Client updateClient(Long id, Client client) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if (existingClient != null) {
            existingClient.setCountry(client.getCountry());
            existingClient.setEmail(client.getEmail());
            existingClient.setFirstName(client.getFirstName());
            existingClient.setLastName(client.getLastName());
            existingClient.setPhoneNumber(client.getPhoneNumber());
            return clientRepository.save(existingClient);
        } else {
            return null;
        }
    }

    public void deleteClientById(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
