package stalterclouse.elspeth.entity.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PageInfo{

	@JsonIgnore
	@JsonProperty("totalResults")
	private int totalResults;

	@JsonIgnore
	@JsonProperty("resultsPerPage")
	private int resultsPerPage;

	@Override
 	public String toString(){
		return 
			"PageInfo{" + 
			"totalResults = '" + totalResults + '\'' + 
			",resultsPerPage = '" + resultsPerPage + '\'' + 
			"}";
		}
}