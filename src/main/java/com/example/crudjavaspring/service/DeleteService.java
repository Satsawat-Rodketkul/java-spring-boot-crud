package com.example.crudjavaspring.service;

import com.example.crudjavaspring.models.request.DeleteRequestModel;
import com.example.crudjavaspring.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DeleteService {

    private final PersonRepository personRepository;

    public ResponseEntity<String> delete(DeleteRequestModel deleteRequestModel) {
        try {
            var personInfo = personRepository.findByFirstname(deleteRequestModel.getFirstName());
            if (personInfo != null) {
                personRepository.deleteById(personInfo.getId());
                log.info("Delete data success");
            } else {
                throw new RuntimeException("Data not found");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Delete data success");
    }
}
