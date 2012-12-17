<%@tag description="asegura que no ingrese un usuario no autenticado"
       pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="titulo"%>
<c:if test="${not gch:esUsuarioAutenticado(pageContext)}">
    <c:redirect url="iniciarSesion" />
</c:if>
<gch:base titulo="${titulo}">
    <jsp:doBody />
</gch:base>
