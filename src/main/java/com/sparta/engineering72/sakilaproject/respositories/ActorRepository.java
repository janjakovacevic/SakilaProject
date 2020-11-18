package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findActorsByFirstNameAndLastName(String firstName, String lastName);
}
