/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.services.impl;

import com.h2h.entities.PdcDetail;
import com.h2h.repositories.PdcDetailRepository;
import com.h2h.services.PdcDetailService;
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
public class PdcDetailServiceImpl implements PdcDetailService {
   
   @Autowired
   private PdcDetailRepository pdcDetailRepository;

   @Override
   public Page<PdcDetail> findAll(Pageable pageable) {
      return pdcDetailRepository.findAll(pageable);
   }
   
   @Override
   public PdcDetail getOne(String id) {
      return pdcDetailRepository.getOne(id);
   }

   @Override
   public PdcDetail save(PdcDetail pdcDetail) {
      return pdcDetailRepository.save(pdcDetail);
   }

   @Override
   public PdcDetail update(PdcDetail pdcDetail) {
      return pdcDetailRepository.save(pdcDetail);
   }

   @Override
   public void deleteById(String id) {
      pdcDetailRepository.deleteById(id);
   }
   
}
