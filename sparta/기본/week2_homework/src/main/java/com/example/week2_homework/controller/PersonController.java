package com.example.week2_homework.controller;

import com.example.week2_homework.domain.Person;
import com.example.week2_homework.domain.PersonDto;
import com.example.week2_homework.domain.PersonRepository;
import com.example.week2_homework.service.PersonService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final PersonRepository personRepository;

    @PostMapping("/api/persons")
    public Person createPerson (@RequestBody PersonDto requestDto){
        Person person = new Person(requestDto);

        return personRepository.save(person);
    }

    @GetMapping("/api/persons")
    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonDto requestDto){
        return personService.update(id,requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id, @RequestBody PersonDto requestDto){
        personRepository.deleteById(id);
        return id;
    }
}
