package com.sparta.engineering72.sakilaproject.entites;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Film {
    private Object filmId;
    private String title;
    private String description;
    private Object releaseYear;
    private Object rentalDuration;
    private BigDecimal rentalRate;
    private Object length;
    private BigDecimal replacementCost;
    private Object rating;
    private Object specialFeatures;
    private Timestamp lastUpdate;
    private Collection<FilmActor> filmActorsByFilmId;
    private Collection<FilmCategory> filmCategoriesByFilmId;
    private Collection<Inventory> inventoriesByFilmId;

    @Id
    @Column(name = "film_id")
    public Object getFilmId() {
        return filmId;
    }

    public void setFilmId(Object filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "release_year")
    public Object getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Object releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "rental_duration")
    public Object getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Object rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Basic
    @Column(name = "rental_rate")
    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Basic
    @Column(name = "length")
    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

    @Basic
    @Column(name = "replacement_cost")
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Basic
    @Column(name = "rating")
    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "special_features")
    public Object getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Object specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(filmId, film.filmId) &&
                Objects.equals(title, film.title) &&
                Objects.equals(description, film.description) &&
                Objects.equals(releaseYear, film.releaseYear) &&
                Objects.equals(rentalDuration, film.rentalDuration) &&
                Objects.equals(rentalRate, film.rentalRate) &&
                Objects.equals(length, film.length) &&
                Objects.equals(replacementCost, film.replacementCost) &&
                Objects.equals(rating, film.rating) &&
                Objects.equals(specialFeatures, film.specialFeatures) &&
                Objects.equals(lastUpdate, film.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description, releaseYear, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate);
    }

    @OneToMany(mappedBy = "filmByFilmId")
    public Collection<FilmActor> getFilmActorsByFilmId() {
        return filmActorsByFilmId;
    }

    public void setFilmActorsByFilmId(Collection<FilmActor> filmActorsByFilmId) {
        this.filmActorsByFilmId = filmActorsByFilmId;
    }

    @OneToMany(mappedBy = "filmByFilmId")
    public Collection<FilmCategory> getFilmCategoriesByFilmId() {
        return filmCategoriesByFilmId;
    }

    public void setFilmCategoriesByFilmId(Collection<FilmCategory> filmCategoriesByFilmId) {
        this.filmCategoriesByFilmId = filmCategoriesByFilmId;
    }

    @OneToMany(mappedBy = "filmByFilmId")
    public Collection<Inventory> getInventoriesByFilmId() {
        return inventoriesByFilmId;
    }

    public void setInventoriesByFilmId(Collection<Inventory> inventoriesByFilmId) {
        this.inventoriesByFilmId = inventoriesByFilmId;
    }
}
