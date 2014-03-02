package fr.jee.projet.dao.test;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
public class DirectoryJDBCTest extends TestCase {

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

	public DirectoryJDBCTest(String name) {
		super(name);
	}

	/**
	 * Composite of tests of the directory interaction.
	 * 
	 * @return the current test.
	 */
	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite("Test de la DAO");
		suite.addTest(new DirectoryJDBCTest("createPersonDB"));
		suite.addTest(new DirectoryJDBCTest("newConnection"));
		suite.addTest(new DirectoryJDBCTest("addPerson1"));
		suite.addTest(new DirectoryJDBCTest("addPerson2"));
		suite.addTest(new DirectoryJDBCTest("findPerson"));
		suite.addTest(new DirectoryJDBCTest("findAllPersons"));
		suite.addTest(new DirectoryJDBCTest("updatePerson"));
		suite.addTest(new DirectoryJDBCTest("deletePerson1"));
		return suite;
	}

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
	 * Test the database creation.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void createPersonDB() throws SQLException {
		directoryDAO.createPersonDB();
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
		Assert.assertEquals(p.getId(), person1.getId());
		Assert.assertEquals(p.getBirthdate(), person1.getBirthdate());
		Assert.assertEquals(p.getFirstName(), person1.getFirstName());
		Assert.assertEquals(p.getMail(), person1.getMail());
		Assert.assertEquals(p.getName(), person1.getName());
		Assert.assertEquals(p.getPassword(), person1.getPassword());
		Assert.assertEquals(p.getWebsite(), person1.getWebsite());
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
		Assert.assertEquals(p.getId(), person2.getId());
		Assert.assertEquals(p.getBirthdate(), person2.getBirthdate());
		Assert.assertEquals(p.getFirstName(), person2.getFirstName());
		Assert.assertEquals(p.getMail(), person2.getMail());
		Assert.assertEquals(p.getName(), person2.getName());
		Assert.assertEquals(p.getPassword(), person2.getPassword());
		Assert.assertEquals(p.getWebsite(), person2.getWebsite());
	}

	/**
	 * Test the search of one person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void findPerson() throws SQLException {
		String expected = "Gairoard Lionel";
		Person actual;
		int id = 1;
		actual = directoryDAO.findPerson(id);
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
		// On récupère la première personne de la BDD ...
		Person q = directoryDAO.findAllPersons().iterator().next();
		// ... et en particulier son id
		int id = q.getId();
		// On modifie son nom et prénom
		q.setFirstName("Ravi");
		q.setName("Pachy");
		// On la met à jour
		directoryDAO.updatePerson(q);
		// On vérifie que la modification est effective après la mise à jour
		Person p = directoryDAO.findPerson(id);
		Assert.assertEquals(p.getId(), q.getId());
		Assert.assertEquals(p.getBirthdate(), q.getBirthdate());
		Assert.assertEquals(p.getFirstName(), q.getFirstName());
		Assert.assertEquals(p.getMail(), q.getMail());
		Assert.assertEquals(p.getName(), q.getName());
		Assert.assertEquals(p.getPassword(), q.getPassword());
		Assert.assertEquals(p.getWebsite(), q.getWebsite());
	}

	/**
	 * Test the delete of the first person.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void deletePerson1() throws SQLException {
		int before = directoryDAO.findAllPersons().size();
		int expected = before - 1;
		// On récupère la première personne de la BDD
		Person q = directoryDAO.findAllPersons().iterator().next();
		directoryDAO.deletePerson(q);
		int actual = directoryDAO.findAllPersons().size();
		Assert.assertEquals(expected, actual);
	}
}
