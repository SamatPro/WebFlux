package ru.itis.flux.services;

import ru.itis.flux.entries.PersonDBRecord;

import java.util.List;

public interface PeopleService {
    List<PersonDBRecord> getAll();
}
