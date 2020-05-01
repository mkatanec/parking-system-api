package hr.fer.seminar.parkingsystemapi.controller;

import hr.fer.seminar.parkingsystemapi.model.Floor;
import hr.fer.seminar.parkingsystemapi.service.FloorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FloorController {
	private final FloorService floorService;

	public FloorController(final FloorService floorService) {
		this.floorService = floorService;
	}

	@GetMapping(value = "/floors")
	public List<Floor> getAllFloors() {
		return floorService.getAllFloors();
	}

	@GetMapping(value = "/floor/{id}")
	public void getFloor(final @PathVariable("id") Long id) {
		floorService.getFloor(id);
	}

	@PostMapping(value = "/floor")
	public Floor createFloor(final @RequestBody Floor floor) {
		return floorService.addFloor(floor);
	}

	@PutMapping(value = "/floor")
	public Floor updateFloor(final @RequestBody Floor floor) {
		return floorService.updateFloor(floor);
	}

	@DeleteMapping(value = "/floor/{id}")
	public void deleteFloor(final @PathVariable("id") Long id) {
		floorService.deleteFloor(id);
	}
}
