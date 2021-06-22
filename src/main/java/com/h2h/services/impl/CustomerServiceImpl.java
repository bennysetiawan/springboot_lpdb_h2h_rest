/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.services.impl;

import com.h2h.entities.Customer;
import com.h2h.repositories.CustomerRepository;
import com.h2h.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jp
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
   
   @Autowired
   private CustomerRepository customerRepository;

   @Override
   public Page<Customer> findAll(Pageable pageable) {
      return customerRepository.findAll(pageable);
   }
   
   @Override
   public Customer getOne(String id) {
      return customerRepository.getOne(id);
   }

   @Override
   public Customer save(Customer customer) {
      return customerRepository.save(customer);
   }

   @Override
   public Customer update(Customer customer) {
      return customerRepository.save(customer);
   }

   @Override
   public void deleteById(String id) {
      customerRepository.deleteById(id);
   }
   
}
