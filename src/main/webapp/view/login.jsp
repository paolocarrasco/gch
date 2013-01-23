<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Inicio Sesi&oacute;n">
    <p class="informacion">
        <em>${mensaje}</em>
    </p>
    <form action="j_spring_security_check" method="post">
        <fieldset>
            <div>
                <label for="usuario">Usuario</label>
                <input type="text" name="usuario" id="usuario" />
            </div>
            <div>
                <label for="clave">Contrase&ntilde;a</label>
                <input type="password" name="clave" id="clave" />
            </div>
        </fieldset>
        <div class="comandos">
            <input type="submit" value="IniciarSesi&oacute;n" />
            <input type="reset" value="Limpiar Formulario" />
        </div>
    </form>
</gch:base>