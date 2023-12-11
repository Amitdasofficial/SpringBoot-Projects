package org.jsp.merpro.service;

import java.util.List;

import org.jsp.merpro.dao.MerchantDao;
import org.jsp.merpro.dto.Merchant;
import org.jsp.merpro.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
      @Autowired
	private MerchantDao merchantDao;
      
      public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant)
      {
    	  ResponseStructure<Merchant> structure=new ResponseStructure<>();
    	  structure.setData(merchantDao.saveMerchant(merchant));
    	  structure.setMessage("Merchant saved Successfully");
    	  structure.setStatusCode(HttpStatus.CREATED.value());
    	  return new ResponseEntity<ResponseStructure<Merchant>> (structure,HttpStatus.CREATED);
      }
      
      public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant)
      {
    	  ResponseStructure<Merchant> structure=new ResponseStructure<>();
    	  structure.setData(merchantDao.saveMerchant(merchant));
    	  structure.setMessage("Merchant Updated");
    	  structure.setStatusCode(HttpStatus.ACCEPTED.value());
    	  return new ResponseEntity<ResponseStructure<Merchant>> (structure,HttpStatus.ACCEPTED);
      }
      
      public ResponseEntity<ResponseStructure<List<Merchant>>> findAllMerchant()
      {
    	  ResponseStructure<List<Merchant>> structure=new ResponseStructure<>();
    	  structure.setMessage("List Of All Merchants");
    	  structure.setData(merchantDao.findAllUsers());
    	  structure.setStatusCode(HttpStatus.OK.value());
    	  return new ResponseEntity<ResponseStructure<List<Merchant>>> (structure,HttpStatus.OK);
      }
}
