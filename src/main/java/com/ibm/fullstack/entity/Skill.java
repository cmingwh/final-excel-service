package com.ibm.fullstack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skill", schema = "fullstack")
public class Skill {

	@Id
	@GeneratedValue
	private Long skillId;

	@Column(name = "name")
	private String name;

	@Column(name = "toc")
	private String toc;

	@Column(name = "prerequeistes")
	private String prerequeistes;

}
