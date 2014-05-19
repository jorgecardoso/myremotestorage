package org.jorgecardoso.remotestorage.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("storeservice")
public interface StoreService extends RemoteService {
	void storeNameValue(String name, String value) throws IllegalArgumentException;
	String getValue(String placeId);
}
