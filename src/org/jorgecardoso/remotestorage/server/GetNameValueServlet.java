package org.jorgecardoso.remotestorage.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GetNameValueServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String placeId = req.getParameter("name");
		
		resp.setContentType("application/json");
		resp.getWriter().write(getSchedule(placeId));
	}
	
	
	public String getSchedule(String placeId) {
		Dao.beginTransaction();
		NameValue nameValue = Dao.getNameValue(placeId);
		Dao.commitOrRollbackTransaction();
		
		if ( null != nameValue ) {
			return nameValue.getValue();
		} else {
			return "";
		}
	}
}
