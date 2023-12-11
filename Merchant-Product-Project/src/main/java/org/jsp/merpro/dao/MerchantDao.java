package org.jsp.merpro.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merpro.dto.Merchant;
import org.jsp.merpro.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository merchantRepository;

	// save Merchant
	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

	// update Merchant
	public Merchant updateMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

	// Find All Users
	public List<Merchant> findAllUsers() {
		return merchantRepository.findAll();
	}
      //find By Id
	public Optional<Merchant> findById(int merchant_id) {

		return merchantRepository.findById(merchant_id);
	}

}
