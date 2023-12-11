package org.jsp.adminbus.controller;

import java.util.List;

import org.jsp.adminbus.dto.Bus;
import org.jsp.adminbus.dto.ResponseStructure;
import org.jsp.adminbus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {
	@Autowired
	private BusService busService;

	// SAVE BUS
	@PostMapping("/buses/{admin_id}")
	public ResponseEntity<ResponseStructure<Bus>> saveBus(@RequestBody Bus bus, @PathVariable int admin_id) {
		return busService.addBus(bus, admin_id);
	}

	// UPDATE BUS
	@PutMapping("/buses")
	public ResponseEntity<ResponseStructure<Bus>> updateBus(@RequestBody Bus bus) {
		return busService.updateBus(bus);
	}

	// FIND BUS BY ADMIN ID
	@GetMapping("/bus/by-admin/{admin_id}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByAdminId(@PathVariable int admin_id) {
		return busService.findBusByAdminId(admin_id);
	}

	// findbus by date of dept and location
	@GetMapping("/bus/by-date-loction")
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusBydateOfDeptandlocation(
			@RequestBody String date_of_departure, @RequestBody String from_location,
			@RequestBody String to_location) {
		return busService.findBusByDeptandLocation(date_of_departure, from_location, to_location);
	}

	// Findbus by bus number
	@GetMapping("/bus/by-busnumber/{bus_number}")
	public ResponseEntity<ResponseStructure<Bus>> findBusByNumber(@PathVariable String bus_number) {
		return busService.findBusByBusNumber(bus_number);
	}

	// Findbus by bus number
	@GetMapping("/bus/by-travelsname")
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByTravelsName(@RequestBody String travels_name) {
		return busService.findBusByTravelsName(travels_name);
	}

	// Find Bus by Date of Departure
	@GetMapping("/bus/by-dateofdept")
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByDateOfDept(@RequestBody String date_of_departure) {
		return busService.FindBusByDateOfDeparture(date_of_departure);
	}
}
