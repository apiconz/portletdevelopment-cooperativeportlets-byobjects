package pe.com.apiconz.example.portlets;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import pe.com.apiconz.example.event.PersonEvent;

public class ReceiverObjectPortlet extends GenericPortlet {

	@RenderMode(name = "VIEW")
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		String action = request.getParameter("success");

		if (action != null && action.equals("success")) {

			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("age", request.getParameter("age"));
			request.setAttribute("gender", request.getParameter("gender"));
			
			getPortletContext().getRequestDispatcher(
					"/WEB-INF/jsp/received.jsp").include(request, response);
		} else {
			getPortletContext()
					.getRequestDispatcher("/WEB-INF/jsp/waiting.jsp").include(
							request, response);
		}

	}

	@ProcessEvent(qname = "{http://portlet.apiconz.info}personEvent")
	public void processPersonEvent(EventRequest request, EventResponse response)
			throws PortletException, IOException {
		Event event = request.getEvent();
		PersonEvent personEvent = (PersonEvent) event.getValue();

		response.setRenderParameter("name", personEvent.getName());
		response.setRenderParameter("age", personEvent.getAge().toString());
		response.setRenderParameter("gender", personEvent.getGender().toString());
		response.setRenderParameter("otro", personEvent.getGender().toString());
		
		response.setRenderParameter("success", "success");

	}

}
