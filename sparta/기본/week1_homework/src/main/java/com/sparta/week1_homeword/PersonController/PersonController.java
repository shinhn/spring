package com.sparta.week1_homeword.PersonController;

import com.sparta.week1_homeword.Person.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myInfo")
    public Person getPerson(){
        Person p1 = new Person();
        p1.setAddress("seoul");
        p1.setAge(24);
        p1.setName("ShinHyeon");
        return p1;
    }
}
