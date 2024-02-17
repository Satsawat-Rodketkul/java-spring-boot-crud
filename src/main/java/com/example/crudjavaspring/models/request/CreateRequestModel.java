package com.example.crudjavaspring.models.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRequestModel {
    private String firstName;
    private String lastName;
}
