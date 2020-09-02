package com.application.MyDaily.domain;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="t_day")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private int value;
}
