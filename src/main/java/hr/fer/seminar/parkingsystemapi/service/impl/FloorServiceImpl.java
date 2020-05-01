package hr.fer.seminar.parkingsystemapi.service.impl;

import hr.fer.seminar.parkingsystemapi.dao.FloorRepository;
import hr.fer.seminar.parkingsystemapi.model.Floor;
import hr.fer.seminar.parkingsystemapi.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {

    private final FloorRepository floorRepository;

    @Autowired
    public FloorServiceImpl(final FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public List<Floor> getAllFloors() {
        final List<Floor> floors = new ArrayList<>();

        floorRepository.findAll().forEach(floors::add);

        return floors;
    }

    @Override
    public Floor getFloor(Long id) {
        return floorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Floor> getFloorsOrderedByLevel(final Integer level) {
        return floorRepository.getOrderedFloors(level);
    }

    @Override
    public Floor findFloorByLevel(final Integer level) {
        return floorRepository.findFloorByLevel(level);
    }

    @Override
    public Floor addFloor(final Floor floor) {
        return floorRepository.save(floor);
    }

    @Override
    public void deleteFloor(final Long id) {
        final Floor floor = getFloor(id);
        floorRepository.delete(floor);
    }

    @Override
    public Floor updateFloor(final Floor floor) {
        return floorRepository.save(floor);
    }
}
