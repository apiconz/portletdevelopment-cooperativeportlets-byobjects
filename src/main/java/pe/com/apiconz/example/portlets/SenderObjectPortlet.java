package pe.com.apiconz.example.portlets;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import pe.com.apiconz.example.bean.Person;
import pe.com.apiconz.example.event.PersonEvent;

public class SenderObjectPortlet extends GenericPortlet {

	@RenderMode(name = "VIEW")
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		String vista = request.getParameter("success");
		if (vista != null && vista.equals("success")) {

			getPortletContext()
					.getRequestDispatcher("/WEB-INF/jsp/success.jsp").include(
							request, response);
		} else {

			PortletURL enviarObjetoURL = response.createActionURL();
			enviarObjetoURL.setParameter(ActionRequest.ACTION_NAME,
					"enviarObjeto");
			request.setAttribute("enviarObjetoURL", enviarObjetoURL);
			getPortletContext().getRequestDispatcher(
					"/WEB-INF/jsp/launcher.jsp").include(request, response);
		}
	}

	@ProcessAction(name = "enviarObjeto")
	public void enviarObjeto(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {

		Person person = new Person();
		person.setName(request.getParameter("name"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
		person.setGender(request.getParameter("gender").charAt(0));

		QName eventName = new QName("http://portlet.apiconz.info",
				"personEvent");
		response.setEvent(eventName, new PersonEvent(person));

		response.setRenderParameter("success", "success");
	}
}
