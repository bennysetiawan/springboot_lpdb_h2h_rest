/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.services.impl;

import com.h2h.entities.Pdc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.h2h.repositories.PdcRepository;
import com.h2h.services.PdcService;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author jp
 */
@Service
@Transactional
public class PdcServiceImpl implements PdcService {
   
   @Autowired
   private PdcRepository pdcRepository;

   @Override
   public Page<Pdc> findAll(Pageable pageable) {
      return pdcRepository.findAll(pageable);
   }
   
   @Override
   public Pdc getOne(String id) {
      return pdcRepository.getOne(id);
   }
   
   @Override
   public List<Pdc> findAllByIdProposal(BigInteger idProposal) {
      return pdcRepository.findAllByIdProposal(idProposal);
   }
   
   @Override
   public Pdc save(Pdc pdc) {
      pdc.setPdcInputDate(new Date());
      return pdcRepository.save(pdc);
   }

   @Override
   public List<Pdc> saveAll(List<Pdc> pdcData) {
      return pdcRepository.saveAll(pdcData);
   }

   @Override
   public Pdc update(Pdc pdcData) {
      return pdcRepository.save(pdcData);
   }

   @Override
   public void deleteById(String id) {
      pdcRepository.deleteById(id);
   }
   
}
