package hr.fer.seminar.parkingsystemapi.service;

import hr.fer.seminar.parkingsystemapi.model.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {
	public List<ParkingSpace> getAllParkingSpaces();

	public ParkingSpace findParkingSpaceById(final Long id);

	public ParkingSpace findClosestParkingSpace(final Long entranceId);

	public ParkingSpace addParkingSpace(final ParkingSpace parkingSpace);

	public void deleteParkingSpace(final Long id);

	public ParkingSpace updateParkingSpace(final ParkingSpace parkingSpace);

	public ParkingSpace updateOccupied(final Long id, final Boolean occupied);

	public Long getNumberOfUnoccupiedSpaces();
}
