package com.example.week2_homework.service;

import com.example.week2_homework.domain.Person;
import com.example.week2_homework.domain.PersonDto;
import com.example.week2_homework.domain.PersonRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    @Transactional
    public long update(Long id, PersonDto requestDto){
        Person person = personRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );
        person.update(requestDto);
        return person.getId();
    }



}
