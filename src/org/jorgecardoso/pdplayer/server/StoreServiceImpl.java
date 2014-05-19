package org.jorgecardoso.pdplayer.server;

import org.jorgecardoso.pdplayer.client.StoreService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class StoreServiceImpl extends RemoteServiceServlet implements StoreService {


	@Override
	public void storeSchedule(String placeId, String scheduleJson)
			throws IllegalArgumentException {
		
		Dao.beginTransaction();
		Schedule schedule = Dao.getSchedule(placeId);
		
		if ( null != schedule ) {
			schedule.setScheduleJson(scheduleJson);
		} else {
			schedule = new Schedule();
			schedule.setPlaceId(placeId);
			schedule.setScheduleJson(scheduleJson);
		}
		Dao.put(schedule);
		Dao.commitOrRollbackTransaction();
	}
	
	
	public String getSchedule(String placeId) {
		Dao.beginTransaction();
		Schedule schedule = Dao.getSchedule(placeId);
		Dao.commitOrRollbackTransaction();
		
		if ( null != schedule ) {
			return schedule.getScheduleJson();
		} else {
			return "";
		}
	}
}
