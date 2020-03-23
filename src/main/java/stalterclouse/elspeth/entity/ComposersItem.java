package stalterclouse.elspeth.entity;

public class ComposersItem{
	private String completeName;
	private String death;
	private String name;
	private String birth;
	private String epoch;
	private String id;
	private String portrait;

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
}
