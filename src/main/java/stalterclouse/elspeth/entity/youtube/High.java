package stalterclouse.elspeth.entity.youtube;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class High{

	@Getter
	@Setter
	@JsonProperty("width")
	private int width;

	@Getter
	@Setter
	@JsonProperty("url")
	private String url;

	@Getter
	@Setter
	@JsonProperty("height")
	private int height;

	@Override
 	public String toString(){
		return 
			"High{" + 
			"width = '" + width + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}