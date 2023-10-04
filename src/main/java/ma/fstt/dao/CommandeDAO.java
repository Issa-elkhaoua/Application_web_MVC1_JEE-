package ma.fstt.dao;

import ma.fstt.entities.Commande;
import ma.fstt.entities.Etat;
import ma.fstt.service.CommandeRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO implements CommandeRepository {

    Connection conn = ConnectionJDBC.getInstance();

    public CommandeDAO() throws SQLException, ClassNotFoundException {
    }

    @Override
    public Commande trouverById(Long id) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("select * from commande WHERE id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Commande c = new Commande();
        rs.next();
        c.setId_commande(id);
        c.setId_client(rs.getLong("client_id"));
        c.setDate(rs.getDate("date"));
        c.setEtat(Etat.valueOf((String) rs.getString("etat")));

        return c;
    }

    @Override
    public void ajouterCommande(Commande commande) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "insert into commande (client_id , date , etat) values(?,?,?)");
        ps.setLong(1, commande.getId_client());
        java.util.Date utilDate = commande.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ps.setDate(2, sqlDate);
        ps.setString(3,commande.getEtat().name());
        ps.execute();
    }

    @Override
    public List<Commande> findAll() throws SQLException {
        List<Commande> commandes=new ArrayList<Commande>();
        PreparedStatement ps = conn.prepareStatement("select * from commande");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Commande c = new Commande();
            c.setId_commande(rs.getLong("id"));
            c.setId_client(rs.getLong("client_id"));
            c.setDate(rs.getDate("date"));
            c.setEtat(Etat.valueOf((String) rs.getString("etat")));

            commandes.add(c);
        }
        return commandes;
    }

    @Override
    public void deleteCommande(Long id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("delete from commande WHERE id = ?");
        ps.setLong(1, id);
        ps.execute();
    }

    @Override
    public Commande updateCommande(Commande commande, Long id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update commande SET client_id = ? , date = ? , etat = ?  WHERE id = ?");
        ps.setLong(1, commande.getId_client());
        ps.setDate(2, (Date) commande.getDate());
        ps.setString(3, commande.getEtat().name());
        ps.setLong(4, id);
        ps.execute();
        return commande;
    }
}
