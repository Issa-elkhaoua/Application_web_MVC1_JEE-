package ma.fstt.dao;

import ma.fstt.dao.ConnectionJDBC;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.Etat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Client cl = new Client(99L,"Fouad","El ","Issa.elkhaoua2001@gmail.com","Tanger","+212663235324");

        ClientDAO cldao = new ClientDAO();

        cldao.ajouterClient(cl);

        Commande cm = new Commande(0L,new Date(1672531200000L), Etat.ANNULEE,cl.getId_client());

        CommandeDAO cmdao = new CommandeDAO();

        cmdao.ajouterCommande(cm);

        for ( Client tmp :cldao.findAll()
        ) {
            System.out.print(tmp.toString());
        }
    }
}
