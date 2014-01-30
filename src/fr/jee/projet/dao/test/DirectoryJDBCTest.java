package fr.jee.projet.dao.test;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.jee.projet.dao.DirectoryDAOImp;
import fr.jee.projet.db.Person;

/**
 * Testing class for JDBC interaction.
 * 
 * @author Lionel Gairoard
 * @author Ravi Patchy
 * @version 1.0
 * @since 1.0
 * 
 */
@SuppressWarnings("deprecation")
public class DirectoryJDBCTest {

	/**
	 * The DAO service's implementation.
	 */
	private DirectoryDAOImp directoryJDBC = new DirectoryDAOImp();

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
		// Initialize the first person.
		person1.setId(1);
		person1.setName("Gairoard");
		person1.setFirstName("Lionel");
		person1.setMail("lionel.gairoard@gmail.com");
		person1.setWebsite("www.google.fr");
		person1.setBirthdate("03/12/1989");
		person1.setPassword("Condemned123?");

		// Initialize the second person.
		person2.setId(2);
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
		boolean expected = true;
		boolean actual = false;

		Connection connection = directoryJDBC.newConnection();
		if (connection != null)
			actual = true;
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test the add of the first person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void addPerson1() throws SQLException {
		directoryJDBC.addPerson(person1);
	}

	/**
	 * Test the add of the second person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void addPerson2() throws SQLException {
		directoryJDBC.addPerson(person2);
	}
	
	/**
	 * Test the search of one person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void findPerson() throws SQLException {
		String expected = "Gairoard Lionel";
		Person actual = null;
		actual = directoryJDBC.findPerson(person1.getId());
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
		actual = directoryJDBC.findAllPersons().size();
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Test the update of the first person.
	 * 
	 * @throws SQLException
	 */
	@Ignore
	public void updatePerson() throws SQLException {
		directoryJDBC.updatePerson(person1);
	}

	/**
	 * Test the delete of the first person.
	 * 
	 * @throws SQLException
	 */
	@Ignore
	public void deletePerson1() throws SQLException {
		directoryJDBC.deletePerson(person1);
	}

	/**
	 * Test the delete of the second person.
	 * 
	 * @throws SQLException
	 */
	@Ignore
	public void deletePerson2() throws SQLException {
		directoryJDBC.deletePerson(person2);
	}

}
