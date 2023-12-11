package org.jsp.adminbus.service;
import java.util.List;
import java.util.Optional;

import org.jsp.adminbus.dao.AdminDao;
import org.jsp.adminbus.dao.BusDao;
import org.jsp.adminbus.dto.Admin;
import org.jsp.adminbus.dto.Bus;
import org.jsp.adminbus.dto.ResponseStructure;
import org.jsp.adminbus.exception.BusNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	@Autowired
	private BusDao busDao;
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Bus>> addBus(Bus bus, int admin_id) {
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		Optional<Admin> dbAdmin = adminDao.findById(admin_id);
		if (dbAdmin.isPresent()) {
			Admin admin = dbAdmin.get();
			admin.getBus().add(bus);
			bus.setAdmin(admin);
			adminDao.registerAdmin(admin);
			structure.setData(busDao.addBus(bus));
			structure.setMessage("Bus saved successfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.CREATED);
		}
		throw new BusNotFoundException("Bus not found");
	}

	public ResponseEntity<ResponseStructure<Bus>> updateBus(Bus bus) {
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		Optional<Bus> recBus = busDao.findById(bus.getId());
		if (recBus.isPresent()) {
			Bus dbBus = recBus.get();
			dbBus.setBus_number(bus.getBus_number());
			dbBus.setDate_of_departure(bus.getDate_of_departure());
			dbBus.setNo_of_seats(bus.getNo_of_seats());
			dbBus.setCost_per_seat(bus.getCost_per_seat());
			dbBus.setFrom_location(bus.getFrom_location());
			dbBus.setTo_location(bus.getTo_location());
			dbBus.setImage_url(bus.getImage_url());
			structure.setData(busDao.updateBus(bus));
			structure.setMessage("Bus Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException("Invalid id");
	}

	// find bus by Admin Id

	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByAdminId(int id) {
		ResponseStructure<List<Bus>> structure = new ResponseStructure<>();
		List<Bus> bus = busDao.findBusByAdminId(id);
		if (bus.size() > 0) {
			structure.setData(bus);
			structure.setMessage("Buses found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException("bus not found with given Admin Id");
	}

	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByDeptandLocation(String date_of_departure,
			String from_location, String to_location) {
		ResponseStructure<List<Bus>> structure=new ResponseStructure<>();
		List<Bus> bus=busDao.findBusByDateofDeptFromlocToLoc(date_of_departure, from_location, to_location);
		
       if(bus.size()>0)
       {
    	   structure.setData(bus);
    	   structure.setMessage("list of buses accroding to date and destination");
    	   structure.setStatusCode(HttpStatus.OK.value());
    	   return new ResponseEntity<ResponseStructure<List<Bus>>> (structure,HttpStatus.OK);
       }
       throw new BusNotFoundException("Bus not found accroding to date and destination");
	}
	
	public  ResponseEntity<ResponseStructure<Bus>> findBusByBusNumber(String bus_number)
	{
		ResponseStructure<Bus> structure=new ResponseStructure<>();
		Optional<Bus> recbus=busDao.findBusByBusNumber(bus_number);
		if(recbus.isPresent())
		{
			structure.setData(recbus.get());
			structure.setMessage("list of buses accroding to bus number");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Bus>> (structure,HttpStatus.OK);
		}
		throw new BusNotFoundException("Invalid Busnumber");
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByTravelsName(String travels_name)
	{
		ResponseStructure<List<Bus>> structure=new ResponseStructure<>();
		List<Bus> bus=busDao.findBusByTravelsName(travels_name);
		if(bus.size()>0)
		{
			structure.setData(bus);
			structure.setMessage("List of Busses accroding to Travels Name");
			structure.setStatusCode(HttpStatus.OK.value());
			return new  ResponseEntity<ResponseStructure<List<Bus>>> (structure,HttpStatus.OK);
			
		}
		throw new BusNotFoundException("No Bus found accroding to Travels name");
	}
	public ResponseEntity<ResponseStructure<List<Bus>>> FindBusByDateOfDeparture(String date_of_departure)
	{
		ResponseStructure<List<Bus>> structure=new ResponseStructure<>();
		List<Bus> bus=busDao.findBusByDateOfDept(date_of_departure);
		if(bus.size()>0)
		{
			structure.setData(bus);
			structure.setMessage("list of buses accroding to date of departure");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>> (structure,HttpStatus.OK);
		}
		throw new BusNotFoundException("Bus not found accroding to date");
	}
}
