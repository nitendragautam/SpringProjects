package com.nitendragautam.utility;


import com.nitendragautam.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class DataUtility {

    /*
    Gets Person Record List
     */

    public  static List<Person> getPersonList(){
        List<Person> personRecords = new ArrayList<>();


        Person personRecord1 = new Person(1L, "ngaut", "Nitendra", "Gautam" ,"Dallas");
        Person personRecord2 = new Person(2L, "dJohn", "John", "Doe" ,"USA");


       personRecords.add(personRecord1);
        personRecords.add(personRecord1);

     return personRecords;
    }


    /*
    Gets Person Records By Id
     */

    public static Person getPersonRecordsByID(Long id){

        List<Person> personRecordList = getPersonList();

       Person person ;
        Person extractedRecord =null;
for(int personRecordIndex =0;personRecordIndex <personRecordList.size() ;personRecordIndex++){
    if(personRecordList.get(personRecordIndex).getId().equals(id)){

        extractedRecord = new Person(personRecordList.get(personRecordIndex).getId() ,
                personRecordList.get(personRecordIndex).getLoginId(),
                personRecordList.get(personRecordIndex).getFirstName(),
                personRecordList.get(personRecordIndex).getLastName(),
                personRecordList.get(personRecordIndex).getCurrentAddress());

    }else{
       extractedRecord = new Person(personRecordList.get(0).getId() ,
                personRecordList.get(0).getLoginId(),
                personRecordList.get(0).getFirstName(),
                personRecordList.get(0).getLastName(),
               personRecordList.get(0).getCurrentAddress());
    }
}

person = extractedRecord;

        return person;
    }
}
