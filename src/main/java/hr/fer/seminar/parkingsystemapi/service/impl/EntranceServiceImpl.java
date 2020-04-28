package hr.fer.seminar.parkingsystemapi.service.impl;

import hr.fer.seminar.parkingsystemapi.dao.EntranceRepository;
import hr.fer.seminar.parkingsystemapi.model.Entrance;
import hr.fer.seminar.parkingsystemapi.service.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntranceServiceImpl implements EntranceService {

	private final EntranceRepository entranceRepository;

	@Autowired
	public EntranceServiceImpl(final EntranceRepository entranceRepository) {
		this.entranceRepository = entranceRepository;
	}

	public List<Entrance> getAllEntrances(){
		final List<Entrance> entrances = new ArrayList<>();

		entranceRepository.findAll().forEach(entrances::add);

		return entrances;
	}

	@Override
	public Entrance findEntranceById(final Long id){
		return entranceRepository.findById(id).orElse(null);
	}

	@Override
	public Entrance findEntranceByName(final String name){
		return  entranceRepository.findEntranceByEntranceName(name);
	}

	@Override
	public Entrance addEntrance(final Entrance entrance){
		return entranceRepository.save(entrance);
	}

	@Override
	public void deleteEntrance(final Long id) {
		final Entrance entrance = findEntranceById(id);
		entranceRepository.delete(entrance);
	}

	@Override
	public Entrance updateEntrance(final Entrance entrance) {
		return entranceRepository.save(entrance);
	}
}
