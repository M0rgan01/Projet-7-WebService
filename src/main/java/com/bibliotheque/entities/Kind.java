package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlTransient;
/**
 * Object representant un genre
 * 
 * @author PICHAT morgan
 *
 */
@Entity
public class Kind implements Serializable{

	@Id 
	@NotBlank(message="kind.name.blank")
	private String name;
		
	@OneToMany(mappedBy="kind")
	private Collection<Book> books;

	public Kind() {
		super();
	}

	public Kind(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Book> getBooks() {
		return books;
	}
	
	@XmlTransient
	public void setOuvrages(Collection<Book> books) {
		this.books = books;
	}
	
	
}
