
package com.microservice.users.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -6758760761406092359L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	@Schema(description = "ID no recibe null", example = "1", required = true)
	private Long id;
	@Column(name = "user_nickname")
	@Schema(description = "Nickname no recibe null", example = "amonroy", required = true)
	private String nickname;
	@Column(name = "user_name")
	@Schema(description = "Name no recibe null", example = "Monro", required = true)
	private String name;
	@Column(name = "user_lastname")
	@Schema(description = "LastName", example = "Que mas", required = false)
	private String lastName;

	@Column(name = "modified_at")
	@Temporal(TemporalType.DATE)
	private Date modifiedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
