package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.LigneCommande;

public interface LigneCommandeRepository {

    public LigneCommande trouverById(Long id) throws Exception;

    void ajouterLigneCommande(LigneCommande ligneCommande) throws Exception;

    public List<LigneCommande> findAll() throws Exception;

    void deleteLigneCommande(Long id) throws Exception;

    public LigneCommande updateLigneCommande(LigneCommande ligneCommande , Long id) throws Exception;
}
