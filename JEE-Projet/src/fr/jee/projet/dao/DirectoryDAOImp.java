package fr.jee.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import fr.jee.projet.dao.DirectoryDAO;
import fr.jee.projet.db.Person;

/**
 * Class implementing the DAO directory interface with JDBC.
 * 
 * @author Lionel Gairoard
 * @author Ravi Pachy
 * @version 1.0
 * @since 1.0
 * 
 */
public class DirectoryDAOImp implements DirectoryDAO {

	private String url, user, password;

	/**
	 * Constructor
	 * 
	 * @param Url
	 *            the URL to access to the DB.
	 * @param user
	 *            the user name to connect with to the DB
	 * @param password
	 *            the password to use to connect to the DB
	 */
	public DirectoryDAOImp(String url, String user, String password) {
		this.setUrl(url);
		this.setUser(user);
		this.setPassword(password);
	}

	/**
	 * @return the user of the DB.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return the password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the url's DB.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set into the DB.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param password
	 *            the password to set for DB connection.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param user
	 *            the user to set for DB connection.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public Collection<Person> findAllPersons() throws SQLException {
		Collection<Person> persons = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// create new connection and statement
			connection = newConnection();

			String query = "SELECT Id, Nom, Prenom FROM Personne";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			persons = new ArrayList<Person>();
			while (resultSet.next()) {
				int ident = resultSet.getInt(1);
				persons.add(findPerson(ident));
			}
		} finally {
			// close result set, prepared statement and connection
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
		return persons;
	}

	@Override
	public Person findPerson(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Person person = null;
		try {
			// create new connection and statement
			connection = newConnection();

			String query = "SELECT Id, Nom, Prenom FROM Personne WHERE Id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			person = new Person();
			resultSet.next();
			int ident = resultSet.getInt(1);
			String nom = resultSet.getString(2);
			String prenom = resultSet.getString(3);
			person.setId(ident);
			person.setName(nom);
			person.setFirstName(prenom);
		} finally {
			// close result set, prepared statement and connection
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
		return person;
	}

	@Override
	public void addPerson(Person p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet keys = null;
		
		try {
			// create new connection and statement
			connection = newConnection();

			String query = "INSERT INTO Personne("
					+ " Nom, Prenom, Mail, Site, Anniversaire, Mdp)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(2, p.getName());
			preparedStatement.setString(3, p.getFirstName());
			preparedStatement.setString(4, p.getMail());
			preparedStatement.setString(5, p.getWebsite());
			preparedStatement.setString(6, p.getBirthdate());
			preparedStatement.setString(7, p.getPassword());
			
			int n = preparedStatement.executeUpdate();

			if(n == 1) {
				keys = preparedStatement.getGeneratedKeys();
				if (keys.next()) {
					p.setId(keys.getInt(1));
				}
			}
			
		} finally {
			// close prepared statement and connection
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
	}

	@Override
	public void deletePerson(Person p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int id = p.getId();
		
		try {
			// create new connection and statement
			connection = newConnection();

			String query = "DELETE FROM Personne WHERE Id = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} finally {
			// close prepared statement and connection
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
	}

	@Override
	public void updatePerson(Person p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// create new connection and statement
			connection = newConnection();

			String query = "UPDATE Personne VALUES (?, ?, ?, ?, ?, ?, ?)"
					+ "WHERE Id = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(8, p.getId());
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getName());
			preparedStatement.setString(3, p.getFirstName());
			preparedStatement.setString(4, p.getMail());
			preparedStatement.setString(5, p.getWebsite());
			preparedStatement.setString(6, p.getBirthdate());
			preparedStatement.setString(7, p.getPassword());

			int nbLignes = preparedStatement.executeUpdate();
			System.out.println(nbLignes + " ligne(s) insérée(s)");
		} finally {
			// close prepared statement and connection
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
	}

	/**
	 * Open a new connection to the postgreSQL's database.
	 * 
	 * @return the connection statement.
	 * @throws SQLException
	 */
	public Connection newConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(getUrl(),
				getUser(), getPassword());
		return connection;
	}

}
