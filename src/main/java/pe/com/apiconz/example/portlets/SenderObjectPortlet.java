package pe.com.apiconz.example.portlets;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SenderObjectPortlet extends GenericPortlet {

	@RenderMode(name = "VIEW")
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/launcher.jsp").include(request, response);
	}

}
