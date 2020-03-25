package stalterclouse.elspeth.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata{

	@JsonProperty("sortdirection")
	private String sortdirection;

	@JsonProperty("moreresultsavailable")
	private boolean moreresultsavailable;

	@JsonProperty("start")
	private int start;

	@JsonProperty("limit")
	private int limit;

	@JsonProperty("sortby")
	private String sortby;

	@JsonProperty("apiversion")
	private int apiversion;

	@JsonProperty("timestamp")
	private int timestamp;

	public void setSortdirection(String sortdirection){
		this.sortdirection = sortdirection;
	}

	public String getSortdirection(){
		return sortdirection;
	}

	public void setMoreresultsavailable(boolean moreresultsavailable){
		this.moreresultsavailable = moreresultsavailable;
	}

	public boolean isMoreresultsavailable(){
		return moreresultsavailable;
	}

	public void setStart(int start){
		this.start = start;
	}

	public int getStart(){
		return start;
	}

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setSortby(String sortby){
		this.sortby = sortby;
	}

	public String getSortby(){
		return sortby;
	}

	public void setApiversion(int apiversion){
		this.apiversion = apiversion;
	}

	public int getApiversion(){
		return apiversion;
	}

	public void setTimestamp(int timestamp){
		this.timestamp = timestamp;
	}

	public int getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"sortdirection = '" + sortdirection + '\'' + 
			",moreresultsavailable = '" + moreresultsavailable + '\'' + 
			",start = '" + start + '\'' + 
			",limit = '" + limit + '\'' + 
			",sortby = '" + sortby + '\'' + 
			",apiversion = '" + apiversion + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}