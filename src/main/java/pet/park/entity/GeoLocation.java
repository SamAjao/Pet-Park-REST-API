package pet.park.entity;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class GeoLocation {
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	public GeoLocation(GeoLocation getLocation){
		this.latitude = getLocation.latitude;
		this.longitude = getLocation.longitude;
	}
}
