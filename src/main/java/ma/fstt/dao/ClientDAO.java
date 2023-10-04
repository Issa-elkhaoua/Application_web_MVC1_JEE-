package ma.fstt.dao;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements ClientRepository {

    Connection conn = ConnectionJDBC.getInstance();

    public ClientDAO() throws SQLException, ClassNotFoundException {
    }

    @Override
    public Client trouverById(Long id) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("select * from client WHERE id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Client c = new Client();
        rs.next();
        dup(rs, c);

        return c;
    }

    @Override
    public void ajouterClient(Client client) throws SQLException {
        System.out.println(" ajouter un client");
        PreparedStatement ps = conn.prepareStatement(
                "insert into client (id , nom , prenom, email ,adresse ,telephone) values(?,?,?,?,?,?)");
        ps.setLong(1, client.getId_client());
        ps.setString(2, client.getNom());
        ps.setString(3, client.getPrenom());
        ps.setString(4, client.getEmail());
        ps.setString(5, client.getAdresse());
        ps.setString(6, client.getTelephone());

        ps.execute();
    }

    @Override
    public List<Client> findAll() throws SQLException {
        List<Client> clients=new ArrayList<Client>();
        PreparedStatement ps = conn.prepareStatement("select * from client");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Client c = new Client();
            dup(rs, c);
            clients.add(c);
        }

        return clients;
    }

    private void dup(ResultSet rs, Client c) throws SQLException {
        c.setId_client(rs.getLong("id"));
        c.setNom(rs.getString("nom"));
        c.setPrenom(rs.getString("prenom"));
        c.setEmail(rs.getString("email"));
        c.setAdresse(rs.getString("adresse"));
        c.setTelephone(rs.getString("telephone"));
    }

    @Override
    public void deleteClient(Long id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("delete from client WHERE id = ?");
        ps.setLong(1, id);
        ps.execute();
    }

    @Override
    public Client updateClient(Client client, Long id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update client SET nom = ? , prenom = ? , email = ? , adresse = ? , telephone = ? WHERE id = ?");
        ps.setString(1, client.getNom());
        ps.setString(2, client.getPrenom());
        ps.setString(3, client.getEmail());
        ps.setString(4, client.getAdresse());
        ps.setString(5, client.getTelephone());

        ps.setLong(6, id);

        ps.execute();
        return client;

    }

}
