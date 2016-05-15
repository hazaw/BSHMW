package com.recruitment.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing Kategoria
 * 
 * @author USER
 *
 */
@Entity
@Table(name = "kategoria")
@Getter
@Setter
@NoArgsConstructor
public class Kategoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@NotNull
	private String nazwa;

	@OneToMany(mappedBy = "kategoria", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Ksiazka> ksiazkiSet;

}
