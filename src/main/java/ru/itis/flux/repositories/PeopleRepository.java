package ru.itis.flux.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.flux.entries.PersonDBRecord;

public interface PeopleRepository extends JpaRepository<PersonDBRecord, Long> {
}
