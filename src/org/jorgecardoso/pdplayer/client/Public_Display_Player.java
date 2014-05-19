package org.jorgecardoso.pdplayer.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Public_Display_Player implements EntryPoint {


	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final StoreServiceAsync storeService = GWT.create(StoreService.class);

	
	private TextBox placeId;
	
	private TextArea schedule;
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		placeId = new TextBox();
		RootPanel.get().add(placeId);
		
		schedule = new TextArea();
		RootPanel.get().add(schedule);
		
		Button get = new Button("Get");
		RootPanel.get().add(get);
		get.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				storeService.getSchedule(placeId.getText(), new AsyncCallback<String>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						schedule.setText(result);
						
					}});
				
			}});
		
		Button send = new Button("Send");
		RootPanel.get().add(send);
		send.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				storeService.storeSchedule(placeId.getText(), schedule.getText(), new AsyncCallback<Void>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Void result) {
						// TODO Auto-generated method stub
						
					}});
				
			}});
		
	}
}
