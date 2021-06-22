/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.repositories;

import com.h2h.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jp
 */
public interface UsersRepository extends JpaRepository<Users, String> {

	Users findByUsername(String username);

	//00001
	@Query("select max(u.code) as nomor from Users u")
	String findByMaxCode();
}
