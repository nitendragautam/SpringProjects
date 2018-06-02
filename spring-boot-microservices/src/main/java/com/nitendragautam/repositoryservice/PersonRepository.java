package com.nitendragautam.repositoryservice;

import com.nitendragautam.domain.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findAllPersonRecords();
    Person findRecordsById(Long recordId);
}
