package com.sparta.engineering72.sakilaproject.entites;

import com.sparta.engineering72.sakilaproject.controller.ActorController;
import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.respositories.ActorRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class Mocktests

{

    @Spy
    @InjectMocks
    ActorController actorController;



    @Mock
     ActorRepository actorRepository;

    @Before()
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testActorbyFirstName() {

        Actor actor = new Actor();
        actor.setActorId(10);

        when(actorRepository.getActorByActorId(10)).thenReturn(actor);

        Actor a = actorController.findActorById(10);

        verify(actorRepository).getActorByActorId(10);

        assertEquals(10, a.getActorId());
    }





}
