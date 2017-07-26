package com.nitendragautam.repositoryservice;

import com.nitendragautam.domain.Person;
import com.nitendragautam.utility.DataUtility;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    public List<Person>  findAllPersonRecords() {

        return DataUtility.getPersonList();
    }

    /*
    Gets the person Records by ID
     */
    public Person findRecordsById(Long recordId) {
        Person personRecord;
if(DataUtility.getPersonRecordsByID(recordId).equals(null)){
    personRecord = DataUtility.getPersonRecordsByID(1L);
}else{
    personRecord =DataUtility.getPersonRecordsByID(recordId);
}
        return personRecord;
    }


}
