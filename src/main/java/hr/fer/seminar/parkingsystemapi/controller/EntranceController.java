package hr.fer.seminar.parkingsystemapi.controller;

import hr.fer.seminar.parkingsystemapi.model.Entrance;
import hr.fer.seminar.parkingsystemapi.service.EntranceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntranceController {
	private final EntranceService entranceService;

	public EntranceController(final EntranceService entranceService) {
		this.entranceService = entranceService;
	}

	@GetMapping(value="/entrances")
	public List<Entrance> getAllEntrances(){
		return entranceService.getAllEntrances();
	}
}
