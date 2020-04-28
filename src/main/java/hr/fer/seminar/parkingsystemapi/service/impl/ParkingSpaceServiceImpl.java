package hr.fer.seminar.parkingsystemapi.service.impl;

import hr.fer.seminar.parkingsystemapi.dao.ParkingSpaceRepository;
import hr.fer.seminar.parkingsystemapi.model.Entrance;
import hr.fer.seminar.parkingsystemapi.model.Floor;
import hr.fer.seminar.parkingsystemapi.model.ParkingSpace;
import hr.fer.seminar.parkingsystemapi.service.EntranceService;
import hr.fer.seminar.parkingsystemapi.service.FloorService;
import hr.fer.seminar.parkingsystemapi.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

	private final ParkingSpaceRepository parkingSpaceRepository;
	private final EntranceService entranceService;
	private final FloorService floorService;

	@Autowired
	public ParkingSpaceServiceImpl(final ParkingSpaceRepository parkingSpaceRepository,
								   final EntranceService entranceService,
								   final FloorService floorService) {
		this.parkingSpaceRepository = parkingSpaceRepository;
		this.entranceService = entranceService;
		this.floorService = floorService;
	}

	@Override
	public List<ParkingSpace> getAllParkingSpaces() {
		final List<ParkingSpace> parkingSpaces = new ArrayList<>();

		parkingSpaceRepository.findAll().forEach(parkingSpaces::add);

		return parkingSpaces;
	}

	@Override
	public ParkingSpace findParkingSpaceById(final Long id) {
		return parkingSpaceRepository.findById(id).orElse(null);
	}

	@Override
	public ParkingSpace findClosestParkingSpace(final Long entranceId) {
		final Long numberOfUnoccupiedSpaces = getNumberOfUnoccupiedSpaces();

		if (numberOfUnoccupiedSpaces == 0) {
			return null;
		}

		final Entrance entrance = entranceService.findEntranceById(entranceId);

		if (entrance == null) {
			return null;
		}

		final List<Floor> floors = floorService.getFloorsOrderedByLevel(entrance.getFloor().getLevel());

		for (Floor floor : floors) {
			final List<ParkingSpace> availableParkingSpaces = parkingSpaceRepository.findAllByFloorAndOccupiedAndReserved(floor, false, false);

			if (!availableParkingSpaces.isEmpty()) {
				final ParkingSpace parkingSpace = availableParkingSpaces.get(0);

				parkingSpace.setReserved(true);
				parkingSpaceRepository.save(parkingSpace);

				return parkingSpace;
			}
		}


		return null;
	}

	@Override
	public ParkingSpace addParkingSpace(final ParkingSpace ParkingSpace) {
		return parkingSpaceRepository.save(ParkingSpace);
	}

	@Override
	public void deleteParkingSpace(final Long id) {
		final ParkingSpace ParkingSpace = findParkingSpaceById(id);
		parkingSpaceRepository.delete(ParkingSpace);
	}

	@Override
	public ParkingSpace updateParkingSpace(final ParkingSpace ParkingSpace) {
		return parkingSpaceRepository.save(ParkingSpace);
	}

	@Override
	public ParkingSpace updateOccupied(final Long id, final Boolean occupied) {
		final ParkingSpace parkingSpace = findParkingSpaceById(id);

		if (occupied && parkingSpace.getReserved()) {
			parkingSpace.setReserved(false);
		}

		parkingSpace.setOccupied(occupied);

		return updateParkingSpace(parkingSpace);
	}

	@Override
	public Long getNumberOfUnoccupiedSpaces() {
		return parkingSpaceRepository.countByOccupiedAndReserved(false, false);
	}
}
