package com.example.crudjavaspring.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequestModel {
    private String oldName;
    private String newName;
}
