package stalterclouse.elspeth.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImslpResponse{

	@JsonProperty("0")
	private JsonMember0 jsonMember0;

	@JsonProperty("metadata")
	private Metadata metadata;

	public void setJsonMember0(JsonMember0 jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public JsonMember0 getJsonMember0(){
		return jsonMember0;
	}

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	@Override
 	public String toString(){
		return 
			"ImslpResponse{" + 
			"0 = '" + jsonMember0 + '\'' + 
			",metadata = '" + metadata + '\'' + 
			"}";
		}
}