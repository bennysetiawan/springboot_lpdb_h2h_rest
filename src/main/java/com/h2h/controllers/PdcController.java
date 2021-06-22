/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.h2h.controllers;

import com.h2h.entities.Pdc;
import com.h2h.entities.ResponseMessage;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.h2h.services.PdcService;
import java.math.BigInteger;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jp
 */
@RestController
@RequestMapping("/pdc")
public class PdcController {

   @Autowired
   private PdcService pdcDataService;
   
   @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
   @GetMapping("")
   public Page<Pdc> findAll(Pageable pageable) {
      return pdcDataService.findAll(pageable);
   }
   
   @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
   @PostMapping("/save-single")
   public ResponseEntity<ResponseMessage> save(
      @RequestBody @Valid Pdc pdc
   ) {
      ResponseMessage responseCustom = new ResponseMessage();
      Pdc p = pdcDataService.save(pdc);
      if(p != null) {
         responseCustom.setCode("00");
         responseCustom.setJumlah(1);
         responseCustom.setMessage("Data berhasil disimpan");
         return new ResponseEntity<>(responseCustom, HttpStatus.CREATED); //201 Created.
      } else {
         responseCustom.setCode("01");
         responseCustom.setJumlah(0);
         responseCustom.setMessage("Data gagal disimpan");
         return new ResponseEntity<>(responseCustom, HttpStatus.NOT_IMPLEMENTED);
      }
      
   }

   @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
   @PostMapping("/save-many")
   public ResponseEntity<ResponseMessage> saveAll(
      @RequestBody @Valid List<Pdc> pdcData
   ) {
      ResponseMessage responseCustom = new ResponseMessage();
      List<Pdc> listPdc = pdcDataService.saveAll(pdcData);
      if(listPdc != null) {
         responseCustom.setCode("00");
         responseCustom.setJumlah(listPdc.size());
         responseCustom.setMessage("Data berhasil disimpan");
         return new ResponseEntity<>(responseCustom, HttpStatus.CREATED); //201 Created.
      } else {
         responseCustom.setCode("01");
         responseCustom.setJumlah(0);
         responseCustom.setMessage("Data gagal disimpan");
         return new ResponseEntity<>(responseCustom, HttpStatus.NOT_IMPLEMENTED); //201 Created.
      }
      
   }
   
   @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
   @GetMapping("/proposal")
   public ResponseEntity<List<Pdc>> findAllByIdProposal(
      @RequestParam("idProposal") BigInteger idProposal
   ) {
      return new ResponseEntity<>(
         pdcDataService.findAllByIdProposal(idProposal), 
         HttpStatus.OK
      ); //200 OK
   }

}
