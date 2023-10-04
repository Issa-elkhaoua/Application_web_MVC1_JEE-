package ma.fstt.entities;

import java.util.Date;

public class Commande {
    private Long id_commande;
    private Date date;
    private Etat etat;
    private Long id_client;

    public Commande() {
    }

    public Commande(Long id_commande, Date date, Etat etat, Long id_client) {
        this.id_commande = id_commande;
        this.date = date;
        this.etat = etat;
        this.id_client = id_client;
    }

    public Long getId_commande() {
        return id_commande;
    }

    public void setId_commande(Long id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id_commande=" + id_commande +
                ", date=" + date +
                ", etat=" + etat +
                '}';
    }
}
