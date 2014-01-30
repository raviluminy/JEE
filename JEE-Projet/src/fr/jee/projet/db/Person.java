package fr.jee.projet.db;

import java.io.Serializable;

/**
 * Class representing the person database.
 * 
 * @author Lionel Gairoard
 * @author Ravi Patchy
 * @version 1.0
 * @since 1.0
 * 
 */
public class Person implements Serializable {

	/**
	 * The Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The identification of the person.
	 */
	private int id;
	
	/**
	 * The name of the person.
	 */
	private String name;

	/**
	 * The first name of the person.
	 */
	private String firstName;

	/**
	 * The mail of the person.
	 */
	private String mail;

	/**
	 * The website of the person.
	 */
	private String website;

	/**
	 * The birthdate of the person.
	 */
	private String birthdate;

	/**
	 * The password of the person.
	 */
	private String password;

	/**
	 * Class constructor.
	 */
	public Person() {

	}

	/**
	 * @return the identification of the person.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the identification to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name of the person.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the first name of the person.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the first name to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the mail of the person.
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set.
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the website of the person.
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set.
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the birthdate of the person.
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate
	 *            the birthdate to set.
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the password of the person.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
