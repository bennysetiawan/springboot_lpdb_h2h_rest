/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.services;

import com.h2h.entities.PdcDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jp
 */
public interface PdcDetailService {

   Page<PdcDetail> findAll(Pageable pageable);

   PdcDetail getOne(String id);

   PdcDetail save(PdcDetail pdcDetail);

   PdcDetail update(PdcDetail pdcDetail);

   void deleteById(String id);
}
