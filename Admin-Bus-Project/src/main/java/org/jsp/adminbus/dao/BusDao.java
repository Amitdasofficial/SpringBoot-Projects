package org.jsp.adminbus.dao;
import java.util.List;
import java.util.Optional;

import org.jsp.adminbus.dto.Bus;
import org.jsp.adminbus.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {
	@Autowired
	private BusRepository busRepository;

	// adding bus
	public Bus addBus(Bus bus) {
		return busRepository.save(bus);
	}

	// update bus details
	public Bus updateBus(Bus bus) {
		return busRepository.save(bus);
	}

	// findBus by admin id
	public List<Bus> findBusByAdminId(int id) {
		return busRepository.findBusByAdminId(id);
	}

	public List<Bus> findBusByDateofDeptFromlocToLoc(String date_of_departure, String from_location,
			String to_location) {
		return busRepository.findBusBydateofDeptFLocatoLocat(date_of_departure, from_location, to_location);
	} 
	      //find bus by bus no
	public Optional<Bus> findBusByBusNumber(String bus_number)
	{
		return busRepository.findBusBybusNo(bus_number);
	}
	
	//find bus by travels name
	public List<Bus> findBusByTravelsName(String travels_name)
	{
		return busRepository.findBusByTravelsName(travels_name);
	}
	     //find Bus by date of Departure
	public List<Bus> findBusByDateOfDept(String date_of_departure)
	{
		return busRepository.findBusByDateOfDeparture(date_of_departure);
	}
                 //find by id
	public Optional<Bus> findById(int id) {
		
		return busRepository.findById(id);
	}
}
