package com.petclinic.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Component
@Scope("prototype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
	
@Id
@GeneratedValue
@Column
private int id;
private String petName;
private String ownerName;
private int petAge;

public int getId() {
	return id;
}
}
