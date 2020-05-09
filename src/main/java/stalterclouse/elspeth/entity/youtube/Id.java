package stalterclouse.elspeth.entity.youtube;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id{

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("videoId")
	private String videoId;

	@JsonProperty("playlistId")
	private String playlistId;

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setVideoId(String videoId){
		this.videoId = videoId;
	}

	public String getVideoId(){
		return videoId;
	}


	public String getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}

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