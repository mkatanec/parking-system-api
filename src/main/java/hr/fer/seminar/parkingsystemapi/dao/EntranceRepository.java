package hr.fer.seminar.parkingsystemapi.dao;

import hr.fer.seminar.parkingsystemapi.model.Entrance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EntranceRepository extends CrudRepository<Entrance, Long> {
	Entrance findEntranceByEntranceName(final String name);
}
