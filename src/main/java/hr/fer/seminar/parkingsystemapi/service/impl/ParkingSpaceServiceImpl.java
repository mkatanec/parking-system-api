package hr.fer.seminar.parkingsystemapi.service.impl;

import hr.fer.seminar.parkingsystemapi.dao.ParkingSpaceRepository;
import hr.fer.seminar.parkingsystemapi.model.ParkingSpace;
import hr.fer.seminar.parkingsystemapi.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

	private final ParkingSpaceRepository parkingSpaceRepository;

	@Autowired
	public ParkingSpaceServiceImpl(final ParkingSpaceRepository parkingSpaceRepository) {
		this.parkingSpaceRepository = parkingSpaceRepository;
	}

	@Override
	public List<ParkingSpace> getAllParkingSpaces(){
		final List<ParkingSpace> parkingSpaces = new ArrayList<>();

		parkingSpaceRepository.findAll().forEach(parkingSpaces::add);

		return parkingSpaces;
	}

	@Override
	public ParkingSpace findParkingSpaceById(final Long id){
		return parkingSpaceRepository.findById(id).orElse(null);
	}

	@Override
	public ParkingSpace findClosestParkingSpace(final Long entranceId) {
		return null;
	}

	@Override
	public ParkingSpace addParkingSpace(final ParkingSpace ParkingSpace){
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
	public Long numberOfUnoccupiedSpaces() {
		return parkingSpaceRepository.countByOccupiedAndReserved(false, false);
	}
}
