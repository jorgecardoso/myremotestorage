package org.jorgecardoso.remotestorage.server;

import org.jorgecardoso.remotestorage.client.StoreService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class StoreServiceImpl extends RemoteServiceServlet implements StoreService {


	@Override
	public void storeNameValue(String name, String value)
			throws IllegalArgumentException {
		
		Dao.beginTransaction();
		NameValue nameValue = Dao.getNameValue(name);
		
		if ( null != nameValue ) {
			nameValue.setValue(value);
		} else {
			nameValue = new NameValue();
			nameValue.setName(name);
			nameValue.setValue(value);
		}
		Dao.put(nameValue);
		Dao.commitOrRollbackTransaction();
	}
	
	
	public String getValue(String name) {
		Dao.beginTransaction();
		NameValue nameValue = Dao.getNameValue(name);
		Dao.commitOrRollbackTransaction();
		
		if ( null != nameValue ) {
			return nameValue.getValue();
		} else {
			return "";
		}
	}
}
