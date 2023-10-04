package ma.fstt.service;

import ma.fstt.entities.Commande;

import java.util.List;

public interface CommandeRepository {

    Commande trouverById(Long id) throws Exception;

    void ajouterCommande(Commande commande) throws Exception;

    public List<Commande> findAll() throws Exception;

    void deleteCommande(Long numCmd) throws Exception;

    public Commande updateCommande(Commande commande , Long id) throws Exception;

}
