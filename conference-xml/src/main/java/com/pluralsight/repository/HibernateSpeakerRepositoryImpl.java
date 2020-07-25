package com.pluralsight.repository;

import com.pluralsight.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    public HibernateSpeakerRepositoryImpl() {
        System.out.println("SpeakerRepository - No args constructor invoked");
    }

    @Override
    public List<Speaker> findAll() {

        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();

        speaker.setFirstName("Raghavan");
        speaker.setLastName("Muthu");

        speakers.add(speaker);

        return speakers;
    }
}
