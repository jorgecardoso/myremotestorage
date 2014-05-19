/**
 * 
 */
package org.jorgecardoso.remotestorage.server;

import java.io.Serializable;
import javax.persistence.Id;

/**
 * @author "Jorge C. S. Cardoso"
 *
 */
public class NameValue implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	/**
	 * the schedule id in the datastore. For now we just use the placeId..
	 */
	@Id 
	private String name;
	

	private String value;
	
	
	public NameValue() {
		//this.pollId = Math.random()*100000000+"";
	
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
