package ma.fstt.service;

import ma.fstt.entities.Client;

import java.util.List;

public interface ClientRepository {

    Client trouverById(Long id) throws Exception;

    void ajouterClient(Client client) throws Exception;

    public List<Client> findAll() throws Exception;

    void deleteClient(Long id) throws Exception;

    public Client updateClient(Client client, Long id) throws Exception;


}
