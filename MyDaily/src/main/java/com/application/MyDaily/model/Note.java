package com.application.MyDaily.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Note")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Date time;
	@ElementCollection(targetClass = Type.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "Types", joinColumns = @JoinColumn(name = "note_id"))
	@Enumerated(EnumType.STRING)
	private Set<Type> types;
}
