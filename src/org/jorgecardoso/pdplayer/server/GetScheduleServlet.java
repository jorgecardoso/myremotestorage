package org.jorgecardoso.pdplayer.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GetScheduleServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String placeId = req.getParameter("placeid");
		
		resp.setContentType("application/json");
		resp.getWriter().write(getSchedule(placeId));
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
