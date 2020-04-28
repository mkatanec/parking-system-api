package hr.fer.seminar.parkingsystemapi.dao;

import hr.fer.seminar.parkingsystemapi.model.Floor;
import hr.fer.seminar.parkingsystemapi.model.ParkingSpace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ParkingSpaceRepository extends CrudRepository<ParkingSpace, Long> {
	Long countByOccupiedAndReserved(final Boolean occupied, final Boolean reserved);

	List<ParkingSpace> findAllByFloorAndOccupiedAndReserved(final Floor floor, final Boolean occupied, final Boolean reserved);
}
