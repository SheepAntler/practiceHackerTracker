package stalterclouse.elspeth.entity.openopus;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ComposersItem{

	@JsonProperty("complete_name")
	private String completeName;

	@JsonProperty("death")
	private String death;

	@JsonProperty("name")
	private String name;

	@JsonProperty("birth")
	private String birth;

	@JsonProperty("epoch")
	private String epoch;

	@JsonProperty("id")
	private String id;

	@JsonProperty("portrait")
	private String portrait;

	public ComposersItem() {
	}

	public ComposersItem(String completeName, String death, String name, String birth, String epoch, String id) {
		this.completeName = completeName;
		this.death = death;
		this.name = name;
		this.birth = birth;
		this.epoch = epoch;
		this.id = id;
	}

	public void setCompleteName(String completeName){
		this.completeName = completeName;
	}

	public String getCompleteName(){
		return completeName;
	}

	public void setDeath(String death){
		this.death = death;
	}

	public String getDeath(){
		return death;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setBirth(String birth){
		this.birth = birth;
	}

	public String getBirth(){
		return birth;
	}

	public void setEpoch(String epoch){
		this.epoch = epoch;
	}

	public String getEpoch(){
		return epoch;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPortrait(String portrait){
		this.portrait = portrait;
	}

	public String getPortrait(){
		return portrait;
	}

	@Override
 	public String toString(){
		return 
			"ComposersItem{" + 
			"complete_name = '" + completeName + '\'' + 
			",death = '" + death + '\'' + 
			",name = '" + name + '\'' + 
			",birth = '" + birth + '\'' + 
			",epoch = '" + epoch + '\'' + 
			",id = '" + id + '\'' + 
			",portrait = '" + portrait + '\'' + 
			"}";
		}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ComposersItem that = (ComposersItem) o;
		return Objects.equals(completeName, that.completeName) &&
				Objects.equals(death, that.death) &&
				Objects.equals(name, that.name) &&
				Objects.equals(birth, that.birth) &&
				Objects.equals(epoch, that.epoch) &&
				Objects.equals(id, that.id) &&
				Objects.equals(portrait, that.portrait);
	}

	@Override
	public int hashCode() {
		return Objects.hash(completeName, death, name, birth, epoch, id, portrait);
	}
}