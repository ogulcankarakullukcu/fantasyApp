package com.ogulcank.fantasyApp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Parameter {
    @Id
    private String paramName;
    private String paramValue;

}
