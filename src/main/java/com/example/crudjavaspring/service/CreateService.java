package com.example.crudjavaspring.service;

import com.example.crudjavaspring.models.entity.PersonEntity;
import com.example.crudjavaspring.models.request.CreateRequestModel;
import com.example.crudjavaspring.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CreateService {

    private final PersonRepository personRepository;

    public ResponseEntity<String> create(CreateRequestModel createRequestModel) {
        var personEntity = new PersonEntity();
        try {
            personEntity.setFirstname(createRequestModel.getFirstName());
            personEntity.setLastname(createRequestModel.getLastName());
            personRepository.save(personEntity);
            log.info("Insert data success");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Insert data success");
    }
}
