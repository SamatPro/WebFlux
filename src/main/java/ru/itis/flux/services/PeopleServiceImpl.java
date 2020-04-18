package ru.itis.flux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.flux.entries.PersonDBRecord;
import ru.itis.flux.repositories.PeopleRepository;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService{

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public List<PersonDBRecord> getAll() {
        return peopleRepository.findAll();
    }
}
