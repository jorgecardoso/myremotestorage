package org.jorgecardoso.remotestorage.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface StoreServiceAsync {
	void storeNameValue(String name, String value, AsyncCallback<Void> callback);
	void getValue(String name, AsyncCallback<String> callback);
}
