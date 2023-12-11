package org.jsp.adminbus.repository;


import java.util.List;
import java.util.Optional;

import org.jsp.adminbus.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository extends JpaRepository<Bus, Integer> {
	@Query("select b from Bus b where b.admin.id=?1")
	List<Bus> findBusByAdminId(int id);

	@Query("select b from Bus b where b.bus_number=?1")
	Optional<Bus> findBusBybusNo(String bus_number);

	@Query("select b from Bus b where b.admin.travels_name=?1")
	List<Bus> findBusByTravelsName(String travels_name);

	@Query("select b from Bus b where b.date_of_departure=?1")
	List<Bus> findBusByDateOfDeparture(String date_of_departure);
	
      @Query("select b from Bus b where b.date_of_departure=?1 and b.from_location=?2 and b.to_location=?3")
	List<Bus> findBusBydateofDeptFLocatoLocat(String date_of_departure,
			String from_location,String to_location);
}
