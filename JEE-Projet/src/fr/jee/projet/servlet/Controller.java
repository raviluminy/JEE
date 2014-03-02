package fr.jee.projet.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jee.projet.dao.DirectoryDAO;
import fr.jee.projet.dao.DirectoryDAOImp;
import fr.jee.projet.db.Person;

/**
 * Servlet implementation class Controller.
 * 
 * @author Lionel Gairoard
 * @author Ravi Pachy
 * @version 1.0
 * @since 1.0
 * 
 */
@WebServlet(urlPatterns = { "*.html" }, loadOnStartup = 1)
public class Controller extends HttpServlet {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * DAO interface.
	 */
	public DirectoryDAO directoryDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context = getServletContext();
		String url = context.getInitParameter("db_url");
		String user = context.getInitParameter("db_user");
		String pass = context.getInitParameter("db_pass");
		this.directoryDAO = new DirectoryDAOImp(url, user, pass);
		directoryDAO = new DirectoryDAOImp(url, user, pass);
	}

	@Override
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

	}

	/**
	 * Select the right service according the servlet request.
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Extract the request
		String action = request.getServletPath();
		String jspPage = null;
		// Choose the right method and execute the request
		if (action.equals("/index.html")) {
			jspPage = doIndex(request);
		} else if (action.equals("/directory.html")) {
			try {
				jspPage = doDirectory(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (action.equals("/details.html")) {
			jspPage = doDetails(request);
		} else if (action.equals("/edition.html")) {
			jspPage = doEdition(request);
		} else if (action.equals("/backup.html")) {
			jspPage = doBackup(request);
		} else {
			throw new ServletException("no action");
		}
		// Call the JSP page
		request.getRequestDispatcher(jspPage).forward(request, response);
	}

	/**
	 * Display the home page.
	 * 
	 * @param request
	 *            : The request at the servlet.
	 * @return The JSP's filename.
	 */
	private String doIndex(HttpServletRequest request) {
		// Récupérer les données reçues du formulaire
		String login = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");

		// Si l'un des champs est vide
		if (login.equals("") || password.equals("")) {
			request.setAttribute("erreur",
					"Vous devez remplir les deux champs.");
			// Redirection vers le formulaire index.jsp
			return "/index.jsp";
		}
		// Sinon
		else {
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			// Redirection vers la page directory.jsp
			return "/directory.jsp";
		}
	}

	/**
	 * Do the backup of an user. If the user is unknown, the method add him into
	 * the database. Otherwise, update the new fields.
	 * 
	 * @param request
	 *            : The request at the servlet.
	 * @return The JSP's filename.
	 */
	private String doBackup(HttpServletRequest request) {
		String nom, prenom, mail, date_naissance, site, pass, pass_confirm;
		int id;
		boolean errors = false;
		StringBuffer message = new StringBuffer();
		String empty = new String("");

		/*
		 * Récupération de l'id de la personne en train d'être modifiée ou en
		 * train d'être insérée; auquel cas l'id vaudra -1
		 */
		id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id")); // A rajouter en
			// type="hidden"
			// dans le
			// formulaire
			// d'édition
		} catch (NumberFormatException e) {
			errors = true;
			message.append("Erreur lors de la récupération de l'id de la "
					+ "personne en cours de modification<br/>");
		}

		/* Récupération des paramètres du formulaire */
		prenom = request.getParameter("userfirstnamesignup");
		nom = request.getParameter("usernamesignup");
		date_naissance = request.getParameter("birthdatesignup");
		mail = request.getParameter("emailsignup");
		site = request.getParameter("websitesignup"); // Facultatif
		pass = request.getParameter("passwordsignup");
		pass_confirm = request.getParameter("passwordsignup_confirm");

		/*
		 * Par défaut, on dit qu'il y a des erreurs. On modifiera s'il n'y en a
		 * pas
		 */
		request.setAttribute("message_type", "error");

		/* Vérification du prénom */
		if (prenom == null || prenom == "") {
			errors = true;
			message.append("Vous devez entrer un prénom<br/>");
		}
		/* Vérification du nom */
		if (nom == null || nom == "") {
			errors = true;
			message.append("Vous devez entrer un nom<br/>");
		}
		/* Vérification de la date de naissance */
		if (date_naissance == null || date_naissance == "") {
			errors = true;
			message.append("Vous devez entrer une date de naissance<br/>");
		}
		/* Vérification du mail */
		if (mail == null || mail == "") {
			errors = true;
			message.append("Vous devez entrer une adresse email<br/>");
		}
		/* Vérification du mot de passe */
		if (pass == null || empty.compareTo(pass) == 0) {
			errors = true;
			message.append("Vous devez spécifier un mot de passe<br/>");
		}
		else if (pass.compareTo(pass_confirm) != 0) {
			errors = true;
			message.append("Les mots de passe ne correspondent pas<br/>");
		}

		/* Si il n'y a eu aucune erreur */
		if (!errors) {
			/* Création du bean à partir des données du formulaire */
			Person p = new Person();
			p.setId(id);
			p.setBirthdate(date_naissance);
			p.setFirstName(prenom);
			p.setMail(mail);
			p.setName(nom);
			p.setPassword(pass);
			p.setWebsite(site);

			/* Si on est en mode édition */
			if (id != -1) {
				try {
					/* Mise à jour de la personne */
					directoryDAO.updatePerson(p);
					/* Si la mise à jour n'a pas levé d'exception */
					request.setAttribute("message_type", "success");
					message.append("La mise à jour a été effectuée avec succès");
				} catch (SQLException e) {
					message.append(e.getMessage() + "<br/>");
				}
			}
			/* Sinon, si on est en mode ajout */
			else {
				try {
					/* Ajout de la personne */
					directoryDAO.addPerson(p);
					/* Si l'insertion n'a pas levé d'exception */
					request.setAttribute("message_type", "success");
					message.append("L'insertion a été effectuée avec succès");
				} catch (SQLException e) {
					message.append(e.getMessage() + "<br/>");
				}
			}
		}

		/* On joint le message contenant le résultat à la requête */
		request.setAttribute("message", message);

		/* On retourne la vue jsp */
		return "/backup.jsp";
	}

	/**
	 * Do the edition of an user.
	 * 
	 * @param request
	 *            : The request at the servlet.
	 * @return The JSP's filename.
	 */
	private String doEdition(HttpServletRequest request) {
		String nom, prenom, mail, date_naissance, site, pass, pass_confirm;
		int id;

		/* Récupération des paramètres du formulaire d'édition */
		prenom = request.getParameter("userfirstnamesignup");
		nom = request.getParameter("usernamesignup");
		date_naissance = request.getParameter("birthdatesignup");
		mail = request.getParameter("emailsignup");
		site = request.getParameter("websitesignup"); // Facultatif
		pass = request.getParameter("passwordsignup");
		pass_confirm = request.getParameter("passwordsignup_confirm");

		return "/edition.jsp";
	}

	/**
	 * Display the details information of an user.
	 * 
	 * @param request
	 *            : The request at the servlet.
	 * @return The JSP's filename.
	 */
	private String doDetails(HttpServletRequest request) {
		String ids = request.getParameter("id");
		Person p = null;
		int id = -1;

		if (ids != null)
			id = Integer.parseInt(request.getParameter("id"));

		if(id != -1) {
			try {
				p = directoryDAO.findPerson(id);
				request.setAttribute("person", p);
			} catch (SQLException e) {e.printStackTrace();}
		}
		request.setAttribute("person", p);
		return "/details.jsp";
	}

	/**
	 * Display the users registered in the database.
	 * 
	 * @param request
	 *            : The request at the servlet.
	 * @return The JSP's filename.
	 * @throws SQLException
	 */
	private String doDirectory(HttpServletRequest request) throws SQLException {
		Collection<Person> col = directoryDAO.findAllPersons();
		request.setAttribute("persons", col);
		return "/directory.jsp";
	}
}