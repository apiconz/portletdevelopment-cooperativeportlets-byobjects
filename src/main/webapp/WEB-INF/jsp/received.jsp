<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<%@ page contentType="text/html" isELIgnored="false"%>

<portlet:defineObjects/>
Nombre: <c:out value='${requestScope.name}'/> <br/>
Edad: <c:out value='${requestScope.age}'/><br/>

Género: <c:choose>
	<c:when test="${requestScope.gender eq 'M'}">
		Masculino
	</c:when>
	<c:otherwise>
		Femenino
	</c:otherwise>
</c:choose>
<c:out value='${requestScope.gender}'/>

<%=renderRequest.getParameter("otro")%>