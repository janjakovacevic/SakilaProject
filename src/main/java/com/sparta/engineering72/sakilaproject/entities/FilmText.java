package com.sparta.engineering72.sakilaproject.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="film_text")
@NamedQuery(name="FilmText.findAll", query="SELECT f FROM FilmText f")
public class FilmText implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Lob
	private String description;

	@Column(nullable=false, length=255)
	private String title;

	public FilmText() {
	}

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}