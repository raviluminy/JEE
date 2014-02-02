package fr.jee.projet.dao.test;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fr.jee.projet.dao.DirectoryDAOImp;
import fr.jee.projet.db.Person;

/**
 * Testing class for JDBC interaction.
 * 
 * @author Lionel Gairoard
 * @author Ravi Pachy
 * @version 1.0
 * @since 1.0
 * 
 */
@SuppressWarnings("deprecation")
public class DirectoryJDBCTest {

	/**
	 * The DAO service's implementation.
	 */
	private DirectoryDAOImp directoryDAO = null;
	
	/**
	 * The first person.
	 */
	private Person person1 = new Person();

	/**
	 * The second person.
	 */
	private Person person2 = new Person();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Initialize the class fields.
		String url = "jdbc:postgresql://localhost/jee";
		String user = "lionel";
		String password = "projet";
		directoryDAO = new DirectoryDAOImp(url, user, password);

		// Initialize the first person.
		person1.setName("Gairoard");
		person1.setFirstName("Lionel");
		person1.setMail("lionel.gairoard@gmail.com");
		person1.setWebsite("www.google.fr");
		person1.setBirthdate("03/12/1989");
		person1.setPassword("Condemned123?");

		// Initialize the second person.
		person2.setName("Gairoard");
		person2.setFirstName("Arnaud");
		person2.setMail("arnaud.gairoard@gmail.com");
		person2.setWebsite("www.youtube.fr");
		person2.setBirthdate("03/12/1989");
		person2.setPassword("evanescence");
	}

	/**
	 * Test the database connection.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void newConnection() throws SQLException {
		Connection connection = directoryDAO.newConnection();
		Assert.assertNotNull(connection);
	}

	/**
	 * Test the add of the first person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void addPerson1() throws SQLException {
		Person p;
		directoryDAO.addPerson(person1);
		p = directoryDAO.findPerson(person1.getId());
		Assert.assertEquals(p.getId(), 			person1.getId());
		Assert.assertEquals(p.getBirthdate(), 	person1.getBirthdate());
		Assert.assertEquals(p.getFirstName(), 	person1.getFirstName());
		Assert.assertEquals(p.getMail(), 		person1.getMail());
		Assert.assertEquals(p.getName(), 		person1.getName());
		Assert.assertEquals(p.getPassword(), 	person1.getPassword());
		Assert.assertEquals(p.getWebsite(), 	person1.getWebsite());
	}

	/**
	 * Test the add of the second person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void addPerson2() throws SQLException {
		Person p;
		directoryDAO.addPerson(person2);
		p = directoryDAO.findPerson(person2.getId());
		Assert.assertEquals(p.getId(), 			person2.getId());
		Assert.assertEquals(p.getBirthdate(), 	person2.getBirthdate());
		Assert.assertEquals(p.getFirstName(), 	person2.getFirstName());
		Assert.assertEquals(p.getMail(), 		person2.getMail());
		Assert.assertEquals(p.getName(), 		person2.getName());
		Assert.assertEquals(p.getPassword(), 	person2.getPassword());
		Assert.assertEquals(p.getWebsite(), 	person2.getWebsite());
	}

	/**
	 * Test the search of one person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void findPerson() throws SQLException {
		String expected = "Gairoard Lionel";
//		directoryDAO.addPerson(person1);
		Person actual;
		actual = directoryDAO.findPerson(person1.getId());
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected,
				actual.getName() + " " + actual.getFirstName());
	}

	/**
	 * Test the search of all persons.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void findAllPersons() throws SQLException {
		int expected = 2;
		int actual;
//		directoryDAO.addPerson(person1);
//		directoryDAO.addPerson(person2);
		actual = directoryDAO.findAllPersons().size();
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test the update of the first person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void updatePerson() throws SQLException {
//		directoryDAO.addPerson(person1);
		person1.setFirstName("Ravi");
		person1.setName("Pachy");
		directoryDAO.updatePerson(person1);
		Person p = directoryDAO.findPerson(1);
		Assert.assertEquals(p.getId(), 			person1.getId());
		Assert.assertEquals(p.getBirthdate(), 	person1.getBirthdate());
		Assert.assertEquals(p.getFirstName(), 	person1.getFirstName());
		Assert.assertEquals(p.getMail(), 		person1.getMail());
		Assert.assertEquals(p.getName(), 		person1.getName());
		Assert.assertEquals(p.getPassword(), 	person1.getPassword());
		Assert.assertEquals(p.getWebsite(), 	person1.getWebsite());
	}

	/**
	 * Test the delete of the first person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void deletePerson1() throws SQLException {
//		directoryDAO.addPerson(person1);
//		directoryDAO.addPerson(person2);
		int expected = 1;
		directoryDAO.deletePerson(person1);
		int actual = directoryDAO.findAllPersons().size();
		Assert.assertEquals(expected, actual);
	}
}
