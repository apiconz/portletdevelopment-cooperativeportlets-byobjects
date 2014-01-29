<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<%@ page contentType="text/html" isELIgnored="false"%>

<form action="<c:out value='${requestScope.enviarObjetoURL}'/>"
	method="POST">
	<label for="name">Nombre</label> <input type="text" name="name" /> <label
		for="age">Edad</label> <input type="text" name="age" maxlength="2" />

	<label for="gender">Género</label> <select name="gender">
		<option value="M">Masculino</option>
		<option value="F">Femenino</option>
	</select> <input type="submit" value="Enviar" />
</form>