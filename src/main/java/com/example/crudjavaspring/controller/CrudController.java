package com.example.crudjavaspring.controller;

import com.example.crudjavaspring.models.entity.PersonEntity;
import com.example.crudjavaspring.models.request.CreateRequestModel;
import com.example.crudjavaspring.models.request.DeleteRequestModel;
import com.example.crudjavaspring.models.request.UpdateRequestModel;
import com.example.crudjavaspring.service.CreateService;
import com.example.crudjavaspring.service.DeleteService;
import com.example.crudjavaspring.service.ReadService;
import com.example.crudjavaspring.service.UpdateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/crud-java-spring-boot")
@AllArgsConstructor
public class CrudController {

    private final CreateService createService;
    private final ReadService readService;
    private final UpdateService updateService;
    private final DeleteService deleteService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CreateRequestModel createRequestModel) {
        return createService.create(createRequestModel);
    }

    @PostMapping("/read")
    public ResponseEntity<List<PersonEntity>> read() {
        return readService.read();
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody UpdateRequestModel updateRequestModel) {
        return updateService.update(updateRequestModel);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody DeleteRequestModel deleteRequestModel) {
        return deleteService.delete(deleteRequestModel);
    }
}
