package stalterclouse.elspeth.entity;

public class Status{

	private String success;
	private String source;
	private String api;
	private int rows;
	private double processingtime;
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
