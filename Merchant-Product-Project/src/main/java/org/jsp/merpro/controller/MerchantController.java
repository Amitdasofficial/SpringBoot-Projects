package org.jsp.merpro.controller;

import java.util.List;

import org.jsp.merpro.dto.Merchant;
import org.jsp.merpro.dto.ResponseStructure;
import org.jsp.merpro.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
	@Autowired
	private MerchantService merchantService;

	// save Merchants
	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
		return merchantService.saveMerchant(merchant);
	}

	// Update Merchant
	@PutMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return merchantService.saveMerchant(merchant);
	}
	//find all Merchants
     @GetMapping("/merchants")
	public ResponseEntity<ResponseStructure<List<Merchant>>> findAllMerchants()
	{
		return merchantService.findAllMerchant();
	}
}
