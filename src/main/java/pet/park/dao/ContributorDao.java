package pet.park.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.park.entity.Contributor;

public interface ContributorDao extends JpaRepository<Contributor, Long> {

	Optional<Contributor> findByContributorEmail(String contributorEmail);

}
