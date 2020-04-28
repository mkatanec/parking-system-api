package hr.fer.seminar.parkingsystemapi.controller;

import hr.fer.seminar.parkingsystemapi.model.ParkingSpace;
import hr.fer.seminar.parkingsystemapi.service.ParkingSpaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingSpaceController {
	private final ParkingSpaceService parkingSpaceService;

	public ParkingSpaceController(final ParkingSpaceService parkingSpaceService) {
		this.parkingSpaceService = parkingSpaceService;
	}

	@GetMapping(value="/parkingSpaces")
	public List<ParkingSpace> getAllParkingSpaces(){
		return parkingSpaceService.getAllParkingSpaces();
	}

	@GetMapping(value="/parkingSpace/entrance/{entranceId}")
	public ParkingSpace getClosestParkingSpace(final @PathVariable(value = "entranceId") Long id){
		return parkingSpaceService.findClosestParkingSpace(id);
	}

	@GetMapping(value="/parkingSpace/unoccupied")
	public Long numberOfUnoccupiedSpaces(){
		return parkingSpaceService.getNumberOfUnoccupiedSpaces();
	}
}
