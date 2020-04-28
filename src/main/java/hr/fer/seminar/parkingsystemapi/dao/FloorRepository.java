package hr.fer.seminar.parkingsystemapi.dao;

import hr.fer.seminar.parkingsystemapi.model.Floor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FloorRepository extends CrudRepository<Floor, Integer> {
	Floor findFloorByLevel(final Integer level);

	@Query("FROM Floor FL ORDER BY ABS(FL.level - :level)")
	List<Floor> getOrderedFloors(final @Param("level") Integer level);

	void deleteFloorByLevel(final Integer level);
}
