package org.jorgecardoso.pdplayer.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface StoreServiceAsync {
	void storeSchedule(String placeid, String scheduleJson, AsyncCallback<Void> callback);
	void getSchedule(String placeId, AsyncCallback<String> callback);
}
