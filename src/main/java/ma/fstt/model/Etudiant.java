package ma.fstt.model;

import java.util.List;

public class Etudiant {

    private Long id_etudiant;
    private String nom;
    private String prenom;
    private Integer age;
    private List<Module> listmods ;

    public List<Module> getListmods() {
        return listmods;
    }

    public void setListmods(List<Module> listmods) {
        this.listmods = listmods;
    }

    public Etudiant() {

    }

    public Etudiant(Long id_etudiant, String nom, String prenom, Integer age) {
        this.id_etudiant = id_etudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Long getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Long id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id_etudiant=" + id_etudiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }
}
