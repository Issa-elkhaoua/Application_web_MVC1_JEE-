package ma.fstt.controllers.Commande;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;


@WebServlet("/DeleteCommandeServlet")
public class DeleteCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeDAO commandeDAO;
	private Commande commande;
	private List<Commande> commandes;
	
	private ClientDAO clientDAO;
	private List<Client> clients;
    
    public DeleteCommandeServlet() {
        super();
        commandeDAO = new CommandeDAO();
		commandes = new ArrayList<>();
		commande = new Commande();
		
		clients = new ArrayList<>();
		clientDAO = new ClientDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numC = request.getParameter("numCmd");
		int numCmd = Integer.parseInt(numC);
		try {
			commandeDAO.deleteCommande(numCmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// recuperer a nouveau la liste des clients
		try {
			clients = clientDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// recuperer a nouveau la liste des commandes
				try {
					commandes = commandeDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		// stocker les donnes recupere dans l'objet request
		request.setAttribute("clients", clients);
		request.setAttribute("commandes", commandes);

	
request.getRequestDispatcher("jsp/commande.jsp").forward(request, response);

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
