package stalterclouse.elspeth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Composer{

	@JsonIgnore
	private Request request;

	//@JsonIgnore
	private List<ComposersItem> composers;

	@JsonIgnore
	private Status status;

	public void setRequest(Request request){
		this.request = request;
	}

	public Request getRequest(){
		return request;
	}

	public void setComposers(List<ComposersItem> composers){
		this.composers = composers;
	}

	public List<ComposersItem> getComposers(){
		return composers;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Composer{" + 
			"request = '" + request + '\'' + 
			",composers = '" + composers + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}