package stalterclouse.elspeth.entity.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Id{

	@Getter
	@Setter
	@JsonProperty("kind")
	private String kind;

	@Getter
	@Setter
	@JsonProperty("videoId")
	private String videoId;

	@JsonIgnore
	@JsonProperty("playlistId")
	private String playlistId;

	@Override
 	public String toString(){
		return 
			"Id{" + 
			"kind = '" + kind + '\'' + 
			",videoId = '" + videoId + '\'' +
			",playlistId = '" + playlistId + '\'' +
			"}";
		}
}