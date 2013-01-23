<%@tag description="asegura que no ingrese un usuario no autenticado"
       pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@attribute name="titulo"%>
<gch:base titulo="${titulo}">
    <jsp:doBody />
</gch:base>
