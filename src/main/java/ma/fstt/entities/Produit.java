package ma.fstt.entities;

public class Produit {
    private Long id_produit;
    private String nom;
    private String description;
    private Float prix;

    public Produit() {
    }

    public Produit(Long id_produit, String nom, String description, Float prix) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id_produit=" + id_produit +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}
