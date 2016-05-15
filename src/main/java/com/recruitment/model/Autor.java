package com.recruitment.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing Autor
 * 
 * @author USER
 *
 */
@Entity
@Table(name = "autor")
@Getter
@Setter
@NoArgsConstructor
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String imie;

	@NotNull
	private String nazwisko;

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "Autor_Ksiazka", joinColumns = {
			@JoinColumn(name = "autor_id") }, inverseJoinColumns = {
					@JoinColumn(name = "ksiazka_id") })
	private Set<Ksiazka> ksiazkiSet;

}
