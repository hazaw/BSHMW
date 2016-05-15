package com.recruitment.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing Ksiazka
 * 
 * @author USER
 *
 */
@Entity
@Table(name = "ksiazka")
@Getter
@Setter
@NoArgsConstructor
public class Ksiazka implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String ISBN;

	@NotNull
	private String tytul;

	@ManyToOne
	private Kategoria kategoria;

	@ManyToMany(mappedBy="ksiazkiSet")
	private Set<Autor> autorSet;

	
}
