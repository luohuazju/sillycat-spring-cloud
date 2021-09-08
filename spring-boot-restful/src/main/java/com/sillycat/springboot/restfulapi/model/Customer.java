package com.sillycat.springboot.restfulapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Data
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "find_customer_by_first_name_and_last_name", query = "select id, first_name, last_name, email, created_time, updated_time from customer where first_name = ?1 and last_name = ?2", resultClass = Customer.class) })
@NamedQueries(value = {
		@NamedQuery(name = "find_customer_by_first_name", query = "select c from Customer c where c.firstName = ?1") })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	@Column(updatable = false, nullable = false, name = "created_time")
	@CreatedDate
	private LocalDateTime createdTime;

	@Column(nullable = false, name = "updated_time")
	@LastModifiedDate
	private LocalDateTime updatedTime;
}
