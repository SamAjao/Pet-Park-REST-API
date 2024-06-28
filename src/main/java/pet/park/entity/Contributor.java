 package pet.park.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Contributor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contributorId; //contributor_id
	
	private String contributorName;
	
	@Column(unique = true)
	private String contributorEmail;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "contributor", cascade = CascadeType.ALL)
	private Set<PetPark> petPark = new HashSet<>();
}
