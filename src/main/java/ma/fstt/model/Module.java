package ma.fstt.model;

public class Module {
    private Long id_module ;
    private String nom ;
    private String prof;
    private Integer coef ;
    private Etudiant et ;

    public Etudiant getEt() {
        return et;
    }

    public void setEt(Etudiant et) {
        this.et = et;
    }

    public Module() {
    }

    public Module(Long id_module, String nom, String prof, Integer coef) {
        this.id_module = id_module;
        this.nom = nom;
        this.prof = prof;
        this.coef = coef;
    }

    public Long getId_module() {
        return id_module;
    }

    public void setId_module(Long id_module) {
        this.id_module = id_module;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Integer getCoef() {
        return coef;
    }

    public void setCoef(Integer coef) {
        this.coef = coef;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id_module=" + id_module +
                ", nom='" + nom + '\'' +
                ", prof='" + prof + '\'' +
                ", coef=" + coef +
                '}';
    }
}
