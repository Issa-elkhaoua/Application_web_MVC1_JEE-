package ma.fstt.dao;

import ma.fstt.entities.LigneCommande;
import ma.fstt.service.LigneCommandeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeDAO implements LigneCommandeRepository {

    Connection conn = ConnectionJDBC.getInstance();

    public LigneCommandeDAO() throws SQLException, ClassNotFoundException {
    }

    @Override
    public LigneCommande trouverById(Long id) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("select * from lignedecommande WHERE id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        LigneCommande l = new LigneCommande();
        rs.next();
        l.setId_LigneCommande(rs.getLong("id"));
        l.setId_commande(rs.getLong("commande_id"));
        l.setId_produit(rs.getLong("produit_id"));
        l.setQuantite(rs.getInt("quantite"));
        l.setPrix(rs.getFloat("prix"));
        return l;
    }


    @Override

    public void ajouterLigneCommande(LigneCommande ligneCommande) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "insert into lignedecommande (commande_id , produit_id , quantite, prix) values(?,?,?,?)");
        ps.setLong(1, ligneCommande.getId_commande());
        ps.setLong(2, ligneCommande.getId_produit());
        ps.setInt(3, ligneCommande.getQuantite());
        ps.setFloat(4, ligneCommande.getPrix());

        ps.execute();
    }

    @Override
    public List<LigneCommande> findAll() throws SQLException {
        List<LigneCommande> ligneCommandes=new ArrayList<LigneCommande>();
        PreparedStatement ps = conn.prepareStatement("select * from lignedecommande");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            LigneCommande lc = new LigneCommande();
            lc.setId_LigneCommande(rs.getLong("id"));
            lc.setId_commande(rs.getLong("commande_id"));
            lc.setId_produit(rs.getLong("produit_id"));
            lc.setQuantite(rs.getInt("quantite"));
            lc.setPrix(rs.getFloat("prix"));
            ligneCommandes.add(lc);
        }

        return ligneCommandes;
    }

    @Override
    public void deleteLigneCommande(Long id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("delete from lignedecommande WHERE id = ?");
        ps.setLong(1, id);
        ps.execute();
    }

    @Override
    public LigneCommande updateLigneCommande(LigneCommande ligneCommande, Long id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update lignedecommande SET commande_id = ? , produit_id = ? , quantite = ? , prix = ? WHERE id = ?");
        ps.setLong(1, ligneCommande.getId_commande());
        ps.setLong(2, ligneCommande.getId_produit());
        ps.setInt(3, ligneCommande.getQuantite());
        ps.setFloat(4, ligneCommande.getPrix());
        ps.setLong(5, id);
        ps.execute();
        return ligneCommande;

    }


}