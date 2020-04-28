package hr.fer.seminar.parkingsystemapi.service;

import hr.fer.seminar.parkingsystemapi.model.Entrance;

import java.util.List;

public interface EntranceService {
	public List<Entrance> getAllEntrances();

	public Entrance findEntranceById(final Long id);

	public Entrance findEntranceByName(final String name);

	public Entrance addEntrance(final Entrance entrance);

	public void deleteEntrance(final Long id);

	public Entrance updateEntrance(final Entrance entrance);
}
