package stalterclouse.elspeth.entity.imslp;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonMember0{

	@JsonProperty("parent")
	private String parent;

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("intvals")
	private List<Object> intvals;

	@JsonProperty("permlink")
	private String permlink;

	public JsonMember0() {
	}

	public JsonMember0(String id, String permlink) {
		this.id = id;
		this.permlink = permlink;
	}

	public void setParent(String parent){
		this.parent = parent;
	}

	public String getParent(){
		return parent;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setIntvals(List<Object> intvals){
		this.intvals = intvals;
	}

	public List<Object> getIntvals(){
		return intvals;
	}

	public void setPermlink(String permlink){
		this.permlink = permlink;
	}

	public String getPermlink(){
		return permlink;
	}

	@Override
 	public String toString(){
		return 
			"JsonMember0{" + 
			"parent = '" + parent + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",intvals = '" + intvals + '\'' + 
			",permlink = '" + permlink + '\'' + 
			"}";
		}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JsonMember0 that = (JsonMember0) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(permlink, that.permlink);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, permlink);
	}
}