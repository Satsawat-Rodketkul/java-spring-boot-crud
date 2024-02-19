package com.example.crudjavaspring;

import com.example.crudjavaspring.controller.CrudController;
import com.example.crudjavaspring.models.entity.PersonEntity;
import com.example.crudjavaspring.service.CreateService;
import com.example.crudjavaspring.service.DeleteService;
import com.example.crudjavaspring.service.ReadService;
import com.example.crudjavaspring.service.UpdateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrudControllerTest {

    @InjectMocks
    private CrudController crudController;

    @Mock
    private CreateService createService;

    @Mock
    private ReadService readService;

    @Mock
    private UpdateService updateService;

    @Mock
    private DeleteService deleteService;

    @Test
    void create_service_success() {
        String responseSuccess = "Insert data success";
        when(createService.create(any())).thenReturn(ResponseEntity.ok(responseSuccess));
        ResponseEntity<String> response = crudController.create(any());
        assertEquals(ResponseEntity.ok(responseSuccess), response);
    }

    @Test
    void read_service_success() {
        List<PersonEntity> personList = Stream.of(
                PersonEntity.builder().id(1L).firstname("test").lastname("test")
                        .createDate(Timestamp.valueOf(LocalDateTime.now())).updateDate(Timestamp.valueOf(LocalDateTime.now())).build(),
                PersonEntity.builder().id(2L).firstname("test2").lastname("test2")
                        .createDate(Timestamp.valueOf(LocalDateTime.now())).updateDate(Timestamp.valueOf(LocalDateTime.now())).build(),
                PersonEntity.builder().id(3L).firstname("test3").lastname("test3")
                        .createDate(Timestamp.valueOf(LocalDateTime.now())).updateDate(Timestamp.valueOf(LocalDateTime.now())).build()
                ).toList();
        when(readService.read()).thenReturn(ResponseEntity.ok(personList));
        ResponseEntity<List<PersonEntity>> response = crudController.read();
        assertEquals(ResponseEntity.ok(personList), response);
    }

    @Test
    void update_service_success() {
        String responseSuccess = "Update data success";
        when(updateService.update(any())).thenReturn(ResponseEntity.ok(responseSuccess));
        ResponseEntity<String> response = crudController.update(any());
        assertEquals(ResponseEntity.ok(responseSuccess), response);
    }

    @Test
    void delete_service_success() {
        String responseSuccess = "Delete data success";
        when(deleteService.delete(any())).thenReturn(ResponseEntity.ok(responseSuccess));
        ResponseEntity<String> response = crudController.delete(any());
        assertEquals(ResponseEntity.ok(responseSuccess), response);
    }
}
