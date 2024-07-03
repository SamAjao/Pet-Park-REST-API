package pet.park.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.park.entity.PetPark;

public interface PetParkDao extends JpaRepository<PetPark, Long> {

}
