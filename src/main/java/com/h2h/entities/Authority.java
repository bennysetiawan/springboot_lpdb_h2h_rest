/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.entities;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jp
 */
@Data
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority, Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @Column(name = "id", unique = true, nullable = false, length = 55)
   private String id;

   @Column(name = "authority", unique = true, nullable = false, length = 25)
   private String authority;

}
