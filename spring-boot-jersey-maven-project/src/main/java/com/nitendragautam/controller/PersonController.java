package com.nitendragautam.controller;

import com.nitendragautam.repositoryservice.PersonRepository;
import com.nitendragautam.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("records")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAllPersonRecords() {
        return personRepository.findAllPersonRecords();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{recordId}")
    public Person findRecordsById(@PathParam("recordId") Long recordId)
    {
        return personRepository.findRecordsById(recordId);
    }
}
