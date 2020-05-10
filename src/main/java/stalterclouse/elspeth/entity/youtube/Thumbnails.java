package stalterclouse.elspeth.entity.youtube;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Thumbnails{

	@Getter
	@Setter
	@JsonProperty("default")
	private JsonMemberDefault jsonMemberDefault;

	@Getter
	@Setter
	@JsonProperty("high")
	private High high;

	@Getter
	@Setter
	@JsonProperty("medium")
	private Medium medium;

	@Override
 	public String toString(){
		return 
			"Thumbnails{" + 
			"default = '" + jsonMemberDefault + '\'' + 
			",high = '" + high + '\'' + 
			",medium = '" + medium + '\'' + 
			"}";
		}
}