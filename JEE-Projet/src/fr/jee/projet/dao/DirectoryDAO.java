package fr.jee.projet.dao;

import java.sql.SQLException;
import java.util.Collection;

import fr.jee.projet.db.Person;

/**
 * Class representing the DAO directory interface for the person class.
 * 
 * @author Lionel Gairoard
 * @author Ravi Pachy
 * @version 1.0
 * @since 1.0
 * 
 */
public interface DirectoryDAO {

	/**
	 * Find all individuals contained in the database.
	 * 
	 * @return all individuals presents in the database.
	 * @throws SQLException
	 */
	Collection<Person> findAllPersons() throws SQLException;

	/**
	 * Find a person from the database.
	 * 
	 * @param id
	 *            the name of the person.
	 * @return the person corresponding to the id.
	 * @throws SQLException
	 */
	Person findPerson(int id) throws SQLException;

	/**
	 * Add a new person in the database.
	 * 
	 * @param p
	 *            the person to add.
	 * @throws SQLException
	 */
	void addPerson(Person p) throws SQLException;

	/**
	 * Delete a person present in the database.
	 * 
	 * @param p
	 *            the person to delete.
	 * @throws SQLException
	 */
	void deletePerson(Person p) throws SQLException;

	/**
	 * Update a person from the database.
	 * 
	 * @param p
	 *            the person to update.
	 * @throws SQLException
	 */
	void updatePerson(Person p) throws SQLException;
}
