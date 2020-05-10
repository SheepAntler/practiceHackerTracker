package stalterclouse.elspeth.entity.youtube;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class YouTubeResponse{

	@Getter
	@Setter
	@JsonProperty("regionCode")
	private String regionCode;

	@Getter
	@Setter
	@JsonProperty("kind")
	private String kind;

	@JsonIgnore
	@JsonProperty("nextPageToken")
	private String nextPageToken;

	@JsonIgnore
	@JsonProperty("pageInfo")
	private PageInfo pageInfo;

	@JsonIgnore
	@JsonProperty("etag")
	private String etag;

	@Getter
	@Setter
	@JsonProperty("items")
	private List<ItemsItem> items;

	@Override
 	public String toString(){
		return 
			"YouTubeResponse{" + 
			"regionCode = '" + regionCode + '\'' + 
			",kind = '" + kind + '\'' + 
			",nextPageToken = '" + nextPageToken + '\'' + 
			",pageInfo = '" + pageInfo + '\'' + 
			",etag = '" + etag + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}