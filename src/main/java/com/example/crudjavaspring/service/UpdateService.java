package com.example.crudjavaspring.service;

import com.example.crudjavaspring.models.request.UpdateRequestModel;
import com.example.crudjavaspring.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class UpdateService {

    private final PersonRepository personRepository;

    public ResponseEntity<String> update(UpdateRequestModel updateRequestModel) {
        try {
            var personInfo = personRepository.findByFirstname(updateRequestModel.getOldName());
            if (personInfo != null) {
                personInfo.setFirstname(updateRequestModel.getNewName());
                personInfo.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
                personRepository.save(personInfo);
                log.info("Update data success");
            } else {
                throw new RuntimeException("Data not found");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Update data success");
    }
}
