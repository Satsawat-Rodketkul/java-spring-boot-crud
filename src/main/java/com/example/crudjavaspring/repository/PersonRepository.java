package com.example.crudjavaspring.repository;

import com.example.crudjavaspring.models.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    PersonEntity findByFirstname(@Param("oldName") String oldName);

}
