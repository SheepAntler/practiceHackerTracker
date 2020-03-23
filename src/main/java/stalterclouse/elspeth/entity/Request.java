package stalterclouse.elspeth.entity;

public class Request{
	private String item;
	private String type;

	public void setItem(String item){
		this.item = item;
	}

	public String getItem(){
		return item;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Request{" + 
			"item = '" + item + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
