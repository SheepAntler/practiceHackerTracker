package stalterclouse.elspeth.entity.openopus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status{

	@JsonProperty("success")
	private String success;

	@JsonProperty("source")
	private String source;

	@JsonProperty("api")
	private String api;

	@JsonProperty("rows")
	private int rows;

	@JsonProperty("processingtime")
	private double processingtime;

	@JsonProperty("version")
	private String version;

	public void setSuccess(String success){
		this.success = success;
	}

	public String getSuccess(){
		return success;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setApi(String api){
		this.api = api;
	}

	public String getApi(){
		return api;
	}

	public void setRows(int rows){
		this.rows = rows;
	}

	public int getRows(){
		return rows;
	}

	public void setProcessingtime(double processingtime){
		this.processingtime = processingtime;
	}

	public double getProcessingtime(){
		return processingtime;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}

	@Override
 	public String toString(){
		return 
			"Status{" + 
			"success = '" + success + '\'' + 
			",source = '" + source + '\'' + 
			",api = '" + api + '\'' + 
			",rows = '" + rows + '\'' + 
			",processingtime = '" + processingtime + '\'' + 
			",version = '" + version + '\'' + 
			"}";
		}
}