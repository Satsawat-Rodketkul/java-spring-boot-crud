package com.example.crudjavaspring.controller;

import com.example.crudjavaspring.models.entity.PersonEntity;
import com.example.crudjavaspring.models.request.CreateRequestModel;
import com.example.crudjavaspring.service.CreateService;
import com.example.crudjavaspring.service.ReadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/crud-java-spring-boot")
@AllArgsConstructor
public class CrudController {

    private final CreateService createService;
    private final ReadService readService;

    @PostMapping("/insert")
    public ResponseEntity<String> create(@RequestBody CreateRequestModel createRequestModel) {
        return createService.create(createRequestModel);
    }

    @PostMapping("/read")
    public ResponseEntity<List<PersonEntity>> read() {
        return readService.read();
    }

}
