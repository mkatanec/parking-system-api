package hr.fer.seminar.parkingsystemapi.service.impl;

import hr.fer.seminar.parkingsystemapi.dao.UserRepository;
import hr.fer.seminar.parkingsystemapi.model.User;
import hr.fer.seminar.parkingsystemapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        final List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public User getUser(final Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(final User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(final Long id) {
        final User user = getUser(id);
        userRepository.delete(user);
    }

    @Override
    public User updateUser(final User user) {
        return userRepository.save(user);
    }
}
