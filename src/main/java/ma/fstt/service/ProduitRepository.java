package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Produit;

public interface ProduitRepository {

    Produit trouverById(Long id) throws Exception;

    void ajouterProduit(Produit produit) throws Exception;

    public List<Produit> findAll() throws Exception;

    void deleteProduit(Long id) throws Exception;

    public Produit updateProduit(Produit produit , Long id) throws Exception;

}
