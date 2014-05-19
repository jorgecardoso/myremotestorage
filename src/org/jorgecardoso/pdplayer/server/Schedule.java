/**
 * 
 */
package org.jorgecardoso.pdplayer.server;

import java.io.Serializable;
import javax.persistence.Id;

/**
 * @author "Jorge C. S. Cardoso"
 *
 */
public class Schedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	/**
	 * the schedule id in the datastore. For now we just use the placeId..
	 */
	@Id 
	private String placeId;
	

	private String scheduleJson;
	
	
	public Schedule() {
		//this.pollId = Math.random()*100000000+"";
	
	}


	/**
	 * @return the placeId
	 */
	public String getPlaceId() {
		return placeId;
	}


	/**
	 * @param placeId the placeId to set
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}


	/**
	 * @return the scheduleJson
	 */
	public String getScheduleJson() {
		return scheduleJson;
	}


	/**
	 * @param scheduleJson the scheduleJson to set
	 */
	public void setScheduleJson(String scheduleJson) {
		this.scheduleJson = scheduleJson;
	}
	
}
