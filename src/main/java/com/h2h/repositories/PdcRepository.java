/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.repositories;

import com.h2h.entities.Pdc;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jp
 */
public interface PdcRepository extends JpaRepository<Pdc, String> {
   
   @Query("SELECT t FROM Pdc t WHERE t.idProposal=:idProposal ORDER BY t.pdcInputDate ASC")
   List<Pdc> findAllByIdProposal(@Param("idProposal") BigInteger idProposal);
   
}
