/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.services;

import com.h2h.entities.Pdc;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jp
 */
public interface PdcService {

   Page<Pdc> findAll(Pageable pageable);

   Pdc getOne(String id);
   
   List<Pdc> findAllByIdProposal(BigInteger idProposal);
   
   Pdc save(Pdc pdc);

   List<Pdc> saveAll(List<Pdc> pdcData);

   Pdc update(Pdc pdcData);

   void deleteById(String id);
}
