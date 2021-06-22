/*
 * لا اله الا الله محمد الرسول الله
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jp
 */
@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", unique = true, nullable = false, length = 55)
	private String id;

	//@NotEmpty //dimatikan karena code dibuat di controller
	@Column(name = "code", unique = true, nullable = false, length = 25)
	private String code;

	@NotEmpty
	@Column(name = "username", unique = true, nullable = false, length = 25)
	private String username;

	@NotEmpty
	@Column(name = "password", unique = false, nullable = false, length = 255)
	private String password;

	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Authority> authorities;

}
