package ma.fstt.dao;

import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO implements ProduitRepository {


    Connection conn = ConnectionJDBC.getInstance();

    public ProduitDAO() throws SQLException, ClassNotFoundException {
    }

    @Override
    public Produit trouverById(Long id) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("select * from produit WHERE id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Produit p = new Produit();
        rs.next();
        p.setId_produit(id);
        p.setNom(rs.getString("nom"));
        p.setDescription(rs.getString("description"));
        p.setPrix(rs.getFloat("prix"));

        return p;
    }

    @Override
    public void ajouterProduit(Produit produit) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "insert into produit (id , nom , description, prix) values(?,?,?,?)");

        ps.setLong(1, produit.getId_produit());
        ps.setString(2, produit.getNom());
        ps.setString(3, produit.getDescription());
        ps.setFloat(4, produit.getPrix());

        ps.execute();
    }

    @Override
    public List<Produit> findAll() throws SQLException {
        List<Produit> produits=new ArrayList<Produit>();
        PreparedStatement ps = conn.prepareStatement("select * from produit");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Produit p = new Produit();
            p.setId_produit(rs.getLong("id"));
            p.setNom(rs.getString("nom"));
            p.setDescription(rs.getString("description"));
            p.setPrix(rs.getFloat("prix"));
            produits.add(p);
        }

        return produits;
    }

    @Override
    public void deleteProduit(Long id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("delete from produit WHERE id = ?");
        ps.setLong(1, id);
        ps.execute();
    }

    @Override
    public Produit updateProduit(Produit produit, Long id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update produit SET nom = ? , description = ? , prix = ?  WHERE id = ?");
        ps.setString(1, produit.getNom());
        ps.setString(2, produit.getDescription());
        ps.setFloat(3, produit.getPrix());
        ps.setLong(4, id);
        ps.execute();

        return produit;

    }
}
