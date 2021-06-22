/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.services;

import com.h2h.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jp
 */
public interface CustomerService {

   Page<Customer> findAll(Pageable pageable);

   Customer getOne(String id);

   Customer save(Customer customer);

   Customer update(Customer customer);

   void deleteById(String id);
}
