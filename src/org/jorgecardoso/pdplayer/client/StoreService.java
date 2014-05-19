package org.jorgecardoso.pdplayer.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("storeservice")
public interface StoreService extends RemoteService {
	void storeSchedule(String placeid, String scheduleJson) throws IllegalArgumentException;
	String getSchedule(String placeId);
}
