package stalterclouse.elspeth.entity.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Snippet{

	@Getter
	@Setter
	@JsonProperty("publishedAt")
	private String publishedAt;

	@Getter
	@Setter
	@JsonProperty("description")
	private String description;

	@Getter
	@Setter
	@JsonProperty("title")
	private String title;

	@Getter
	@Setter
	@JsonProperty("thumbnails")
	private Thumbnails thumbnails;

	@Getter
	@Setter
	@JsonProperty("channelId")
	private String channelId;

	@Getter
	@Setter
	@JsonProperty("channelTitle")
	private String channelTitle;

	@JsonIgnore
	@JsonProperty("liveBroadcastContent")
	private String liveBroadcastContent;

	@Getter
	@Setter
	@JsonProperty("publishTime")
	private String publishTime;

	@Override
 	public String toString(){
		return 
			"Snippet{" + 
			"publishedAt = '" + publishedAt + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",thumbnails = '" + thumbnails + '\'' + 
			",channelId = '" + channelId + '\'' + 
			",channelTitle = '" + channelTitle + '\'' + 
			",liveBroadcastContent = '" + liveBroadcastContent + '\'' +
			",publishTime = '" + publishTime + '\'' +
			"}";
		}
}