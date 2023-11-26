package jpaDB.mapping.service;

import jpaDB.mapping.domain.Location;
import jpaDB.mapping.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    @Transactional
    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    public Location findOne(Long id) {
        return locationRepository.findOne(id);
    }

    public List<Location> findLocations() {
        return locationRepository.findAll();
    }

}
