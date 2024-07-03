package pet.park.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.park.controller.model.ContributorData;
import pet.park.dao.ContributorDao;
import pet.park.entity.Contributor;

@Service
public class ParkService {
	
	@Autowired
	private ContributorDao contributorDao;
	
	@Transactional(readOnly = false)
	public ContributorData saveContributor(ContributorData contributorData) {
		Long contributorId = contributorData.getContributorId();
		Contributor contributor =findOrCreateContributor(contributorId, contributorData.getContributorEmail());
		
		setFieldsInContributor(contributor, contributorData);
		return new ContributorData(contributorDao.save(contributor));
	}

	private void setFieldsInContributor(Contributor contributor, ContributorData contributorData) {
		contributor.setContributorEmail(contributorData.getContributorEmail());
		contributor.setContributorName(contributorData.getContributorName());
	}

	private Contributor findOrCreateContributor(Long contributorId, String contributorEmail) {
		Contributor contributor;
		
		if(Objects.isNull(contributorId)) {
			Optional<Contributor> opContrib = contributorDao.findByContributorEmail(contributorEmail);
			
			if(opContrib.isPresent()) {
				throw new DuplicateKeyException("Contributor with email " + contributorEmail + " already exists");
			}
			
			contributor = new Contributor();
		}
		else {
			contributor = findContributorById(contributorId);
		}
		
		return contributor;
	}

	private Contributor findContributorById(Long contributorId) {
		return contributorDao.findById(contributorId)
				.orElseThrow(() -> new NoSuchElementException
						("Contributor with ID=" + contributorId + " was not found"));
	}

	
	@Transactional(readOnly = true)
	public List<ContributorData> retrieveAllContributors() {
//		List<Contributor> contributors = contributorDao.findAll();
//		List<ContributorData> response = new LinkedList<ContributorData>();
//		
//		for(Contributor contributor : contributors) {
//			response.add(new ContributorData(contributor));
//		}
//		
//		return response;
	
	//@foramatter:off
	return contributorDao.findAll()
		.stream()
		.map(ContributorData::new)
		.toList();
	//@foramatter:on
		
	}

	public ContributorData retrieveContributorById(Long contributorId) {
		Contributor contributor = findContributorById(contributorId);
		
		return new ContributorData(contributor);
	}

}
