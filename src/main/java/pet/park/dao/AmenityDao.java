package pet.park.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.park.entity.Amenity;

public interface AmenityDao extends JpaRepository<Amenity, Long> {

	Set<Amenity> findAllByAmenityIn(Set<String> amenities);

}
