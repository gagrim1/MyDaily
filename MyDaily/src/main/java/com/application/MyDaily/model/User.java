package com.application.MyDaily.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usr")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
}
