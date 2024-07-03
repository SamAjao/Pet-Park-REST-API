package pet.park.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.park.entity.Amenity;
import pet.park.entity.Contributor;
import pet.park.entity.GeoLocation;
import pet.park.entity.PetPark;

@Data
@NoArgsConstructor
public class PetParkData {
	private Long petParkId;
	private String parkName;
	private String directions;
	private String stateOrProvince;
	private String country;
	private GeoLocation geoLocation;
	private PetParkContributor contributor;
	private Set<String> amenities = new HashSet<>();
	
	public PetParkData(PetPark petPark) {
		petParkId = petPark.getPetParkId();
		parkName = petPark.getParkName();
		directions = petPark.getDirections();
		stateOrProvince = petPark.getStateOrProvince();
		country = petPark.getCountry();
		geoLocation = petPark.getGeoLocation();
		contributor = new PetParkContributor(petPark.getContributor());
		
		for(Amenity amenity : petPark.getAmenities()) {
			amenities.add(amenity.getAmenity());
		}
	}
	
	@Data
	@NoArgsConstructor
	public static class PetParkContributor {
		private Long contributorId; //contributor_id
		private String contributorName;
		private String contributorEmail;
		
		public PetParkContributor (Contributor contributor) {
			contributorId = contributor.getContributorId();
			contributorName = contributor.getContributorName();
			contributorEmail = contributor.getContributorEmail();
		}
	}
	
	
}
