package com.intraway.fizzbuzz.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * The persistent class for the operations database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "operations")
@NamedQuery(name = "Operation.findAll", query = "SELECT o FROM Operation o")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_id")
	private Integer operationId;

	@Column(name = "has_five_multiple")
	private Boolean hasFiveMultiple;

	@Column(name = "has_three_multiple")
	private Boolean hasThreeMultiple;

	private String list;

	@Column(name = "max_value")
	private Integer maxValue;

	@Column(name = "min_value")
	private Integer minValue;

	private Timestamp timestamp;

}