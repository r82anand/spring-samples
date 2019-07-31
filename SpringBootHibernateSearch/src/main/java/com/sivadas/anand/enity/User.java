package com.sivadas.anand.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * An entity User composed by four fields (id, email, name, city). The
 * annotation Indexed marks User as an entity which needs to be indexed by
 * Hibernate Search.
 *
 */
@Entity
@Indexed
@Table(name = "users")
public class User {

	/**
	 * Hibernate Search needs to store the entity identifier in the index for each
	 * entity. By default, it will use for this purpose the field marked with Id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * You have to mark the fields you want to make searchable annotating them with
	 * Field. The parameter Store.NO ensures that the actual data will not be stored
	 * in the index (mantaining the ability to search for it): Hibernate Search will
	 * execute a Lucene query in order to find the database identifiers of the
	 * entities matching the query and use these identifiers to retrieve managed
	 * objects from the database.
	 */
	@Field(store = Store.NO)
	// store=Store.NO is the default values and could be omitted.
	@NotNull
	private String email;

	@Field
	@NotNull
	private String name;

	@Field
	@NotNull
	private String city;

	public User() {
	}

	public User(final long id) {
		this.id = id;
	}

	public User(final String email, final String name) {
		this.email = email;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(final long value) {
		this.id = value;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String value) {
		this.email = value;
	}

	public String getName() {
		return name;
	}

	public void setName(final String value) {
		this.name = value;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String value) {
		this.city = value;
	}

}
