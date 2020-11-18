package com.sparta.engineering72.sakilaproject.entites;

import javax.persistence.*;

@Entity
@Table(name = "actor_info", schema = "sakila", catalog = "")
public class ActorInfo {
    private Integer actorId;
    private String firstName;
    private String lastName;
    private String filmInfo;

    @Id
    @Basic
    @Column(name = "actor_id")
    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "film_info")
    public String getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorInfo actorInfo = (ActorInfo) o;

        if (actorId != null ? !actorId.equals(actorInfo.actorId) : actorInfo.actorId != null) return false;
        if (firstName != null ? !firstName.equals(actorInfo.firstName) : actorInfo.firstName != null) return false;
        if (lastName != null ? !lastName.equals(actorInfo.lastName) : actorInfo.lastName != null) return false;
        if (filmInfo != null ? !filmInfo.equals(actorInfo.filmInfo) : actorInfo.filmInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorId != null ? actorId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (filmInfo != null ? filmInfo.hashCode() : 0);
        return result;
    }
}
