package hr.fer.seminar.parkingsystemapi.controller;

import hr.fer.seminar.parkingsystemapi.model.ParkingSpace;
import hr.fer.seminar.parkingsystemapi.service.ParkingSpaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingSpaceController {
	private final ParkingSpaceService parkingSpaceService;

	public ParkingSpaceController(final ParkingSpaceService parkingSpaceService) {
		this.parkingSpaceService = parkingSpaceService;
	}

	@GetMapping(value = "/parkingSpaces")
	public List<ParkingSpace> getAllParkingSpaces() {
		return parkingSpaceService.getAllParkingSpaces();
	}

	@GetMapping(value = "/parkingSpace/entrance/{entranceId}")
	public ParkingSpace getClosestParkingSpace(final @PathVariable(value = "entranceId") Long id) {
		return parkingSpaceService.findClosestParkingSpace(id);
	}

	@PutMapping(value = "/parkingSpace/occupied/{id}")
	public ParkingSpace updateParkingSpaceOccupied(final @PathVariable(value = "id") Long id, final @RequestBody Boolean occupied) {
		return parkingSpaceService.findClosestParkingSpace(id);
	}

	@GetMapping(value = "/parkingSpace/unoccupied")
	public Long numberOfUnoccupiedSpaces() {
		return parkingSpaceService.getNumberOfUnoccupiedSpaces();
	}

	@PostMapping(value = "/parkingSpace")
	public ParkingSpace createParkingSpace(final @RequestBody ParkingSpace parkingSpace) {
		return parkingSpaceService.addParkingSpace(parkingSpace);
	}

	@PutMapping(value = "/parkingSpace")
	public ParkingSpace updateParkingSpace(final @RequestBody ParkingSpace parkingSpace) {
		return parkingSpaceService.updateParkingSpace(parkingSpace);
	}

	@DeleteMapping(value = "/parkingSpace/{id}")
	public void deleteParkingSpace(final @PathVariable("id") Long id) {
		parkingSpaceService.deleteParkingSpace(id);
	}
}
