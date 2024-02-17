package com.example.crudjavaspring.service;

import com.example.crudjavaspring.models.entity.PersonEntity;
import com.example.crudjavaspring.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReadService {

    private final PersonRepository personRepository;

    public ResponseEntity<List<PersonEntity>> read() {
        List<PersonEntity> response = new ArrayList<>();
        try {
            var personList = personRepository.findAll();
            response.addAll(personList);
            log.info("Read data success");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
