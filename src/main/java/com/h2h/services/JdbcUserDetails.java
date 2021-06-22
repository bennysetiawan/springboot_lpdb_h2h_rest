/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.services;

import com.h2h.entities.Users;
import com.h2h.repositories.UsersRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author jp
 */
public class JdbcUserDetails implements UserDetailsService {
   
   private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      LOG.info("--- Start Login ---");
      LOG.info("username : " + username);
		    Users users = usersRepository.findByUsername(username);

		if (users == null) {
         LOG.info("username tidak ditemukan.");
         LOG.info("--- End Login ---");
			throw new UsernameNotFoundException("User" + username + "can not be found");
		}

		User user = new User(users.getUsername(), users.getPassword(), users.isEnabled(), true, true, true, users.getAuthorities());
      user.getAuthorities().forEach((authority) -> {
         LOG.info("getAuthority() : " + authority.getAuthority());
      });
      LOG.info("--- End Login ---");
		return user;
	}
}
