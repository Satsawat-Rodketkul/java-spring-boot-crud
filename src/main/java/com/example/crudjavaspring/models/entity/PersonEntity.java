package com.example.crudjavaspring.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private Timestamp createDate;
    private Timestamp updateDate;

    @PrePersist
    private void initData() {
        createDate = Timestamp.valueOf(LocalDateTime.now());
        updateDate = Timestamp.valueOf(LocalDateTime.now());
    }

}
