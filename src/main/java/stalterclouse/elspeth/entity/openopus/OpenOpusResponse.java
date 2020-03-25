package stalterclouse.elspeth.entity.openopus;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenOpusResponse{

	@JsonProperty("request")
	private Request request;

	@JsonProperty("composers")
	private List<ComposersItem> composers;

	@JsonProperty("status")
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
			"OpenOpusResponse{" + 
			"request = '" + request + '\'' + 
			",composers = '" + composers + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}