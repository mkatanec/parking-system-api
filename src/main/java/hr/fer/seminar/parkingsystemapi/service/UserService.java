package hr.fer.seminar.parkingsystemapi.service;

import hr.fer.seminar.parkingsystemapi.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(final Long id);

    User addUser(final User User);

    void deleteUser(final Long id);

    User updateUser(final User User);
}
