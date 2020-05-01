package hr.fer.seminar.parkingsystemapi.dao;

import hr.fer.seminar.parkingsystemapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
