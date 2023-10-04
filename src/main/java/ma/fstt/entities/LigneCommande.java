package ma.fstt.entities;

public class LigneCommande {
    private Long id_LigneCommande;
    private Integer quantite;
    private Float prix;
    private Long id_commande;
    private Long id_produit;
    public LigneCommande() {
    }

    public LigneCommande(Long id_LigneCommande, Integer quantite, Float prix, Long id_commande, Long id_produit) {
        this.id_LigneCommande = id_LigneCommande;
        this.quantite = quantite;
        this.prix = prix;
        this.id_commande = id_commande;
        this.id_produit = id_produit;
    }

    public Long getId_LigneCommande() {
        return id_LigneCommande;
    }

    public void setId_LigneCommande(Long id_LigneCommande) {
        this.id_LigneCommande = id_LigneCommande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Long getId_commande() {
        return id_commande;
    }

    public void setId_commande(Long id_commande) {
        this.id_commande = id_commande;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "id_Lignedecommande=" + id_LigneCommande +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
