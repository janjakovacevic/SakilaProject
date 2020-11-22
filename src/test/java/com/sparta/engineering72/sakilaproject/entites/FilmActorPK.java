package com.sparta.engineering72.sakilaproject.entites;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FilmActorPK implements Serializable {
    private Object actorId;
    private Object filmId;

    @Column(name = "actor_id")
    @Id
    public Object getActorId() {
        return actorId;
    }

    public void setActorId(Object actorId) {
        this.actorId = actorId;
    }

    @Column(name = "film_id")
    @Id
    public Object getFilmId() {
        return filmId;
    }

    public void setFilmId(Object filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorPK that = (FilmActorPK) o;
        return Objects.equals(actorId, that.actorId) &&
                Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }
}
