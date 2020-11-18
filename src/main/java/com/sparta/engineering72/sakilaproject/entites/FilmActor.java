package com.sparta.engineering72.sakilaproject.entites;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "film_actor", schema = "sakila", catalog = "")
@IdClass(FilmActorPK.class)
public class FilmActor {
    private Integer actorId;
    private Integer filmId;
    private Timestamp lastUpdate;
    private Actor actorByActorId;
    private Film filmByFilmId;

    @Id
    @Column(name = "actor_id")
    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Id
    @Column(name = "film_id")
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
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

        FilmActor filmActor = (FilmActor) o;

        if (actorId != null ? !actorId.equals(filmActor.actorId) : filmActor.actorId != null) return false;
        if (filmId != null ? !filmId.equals(filmActor.filmId) : filmActor.filmId != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(filmActor.lastUpdate) : filmActor.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorId != null ? actorId.hashCode() : 0;
        result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id", nullable = false)
    public Actor getActorByActorId() {
        return actorByActorId;
    }

    public void setActorByActorId(Actor actorByActorId) {
        this.actorByActorId = actorByActorId;
    }

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    public Film getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(Film filmByFilmId) {
        this.filmByFilmId = filmByFilmId;
    }
}
