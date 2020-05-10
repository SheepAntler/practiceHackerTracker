package stalterclouse.elspeth.entity.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class ItemsItem{

	@Getter
	@Setter
	@JsonProperty("snippet")
	private Snippet snippet;

	@Getter
	@Setter
	@JsonProperty("kind")
	private String kind;

	@JsonIgnore
	@JsonProperty("etag")
	private String etag;

	@Getter
	@Setter
	@JsonProperty("id")
	private Id id;

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"snippet = '" + snippet + '\'' + 
			",kind = '" + kind + '\'' + 
			",etag = '" + etag + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}