package fr.jee.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

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
		int ident;
		try {
			// create new connection and statement
			connection = newConnection();

			String query = "SELECT Id, Nom, Prenom, Mail, Site, Anniversaire, Mdp"
					+ " FROM Personne WHERE Id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			if (resultSet.next()) {
				person = new Person();
				person.setId(resultSet.getInt("Id"));
				person.setName(resultSet.getString("Nom"));
				person.setFirstName(resultSet.getString("Prenom"));
				person.setWebsite(resultSet.getString("Site"));
				person.setBirthdate(resultSet.getString("Anniversaire"));
				person.setMail(resultSet.getString("Mail"));
				person.setPassword(resultSet.getString("Mdp"));
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
					+ "Id, Nom, Prenom, Mail, Site, Anniversaire, Mdp)"
					+ "VALUES (default, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, p.getName());
			preparedStatement.setString(2, p.getFirstName());
			preparedStatement.setString(3, p.getMail());
			preparedStatement.setString(4, p.getWebsite());
			preparedStatement.setString(5, p.getBirthdate());
			preparedStatement.setString(6, p.getPassword());

			int n = preparedStatement.executeUpdate();

			if (n == 1) {
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
		try {
			// create new connection and statement
			connection = newConnection();

			String query = "DELETE FROM Personne WHERE Id = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, p.getId());
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

			String query = "UPDATE Personne SET Nom = ?, Prenom = ?, Mail = ?,"
					+ "Site = ?, Anniversaire = ?, Mdp = ? WHERE Id = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, p.getName());
			preparedStatement.setString(2, p.getFirstName());
			preparedStatement.setString(3, p.getMail());
			preparedStatement.setString(4, p.getWebsite());
			preparedStatement.setString(5, p.getBirthdate());
			preparedStatement.setString(6, p.getPassword());
			preparedStatement.setInt(7, p.getId());

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
