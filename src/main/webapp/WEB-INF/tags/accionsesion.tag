<%@tag description="pone un enlace para iniciar/cerrar sesion, segun estado"
       pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@attribute name="message"%>
<a href="#" title="Para este ejemplo de EJB vamos a obviar la seguridad">Acceso libre</a>
<%--<c:choose>
    <c:when test="${gch:esUsuarioAutenticado()}">
        <a href="cerrarSesion">Cerrar Sesi&oacute;n</a>
    </c:when>
    <c:otherwise>
        <a href="iniciarSesion">Iniciar Sesi&oacute;n</a>
    </c:otherwise>
</c:choose>--%>

