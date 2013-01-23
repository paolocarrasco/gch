<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Profesor">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="registrarProfesor" method="post">
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" required autofocus >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos Personales</legend>
            <div>
                <label for="nombres">Nombres</label>
                <input type="text" id="nombres" name="nombres" required maxlength="50" />
            </div>
            <div>
                <label for="apellidoPaterno">Apellido Paterno</label>
                <input type="text" id="apellidoPaterno" name="apellidoPaterno" required maxlength="50" />
            </div>
            <div>
                <label for="apellidoMaterno">Apellido Materno</label>
                <input type="text" id="apellidoMaterno" name="apellidoMaterno" maxlength="50" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Direcci&oacute;n</legend>
            <div>
                <label for="direccion">Direcci&oacute;n Completa</label>
                <input type="text" id="direccion" name="direccion" required maxlength="400" />
            </div>
            <div>
                <label for="referencia">Referencia</label>
                <input type="text" id="referencia" name="referencia" maxlength="400" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Detalle</legend>
            <div>
                <label for="fechaNacimiento">
                    Fecha de Nacimiento
                </label>
                <input type="date" name="fechaNacimiento" id="fechaNacimiento" required />
            </div>
            <div>
                <span>Sexo</span>
                <label for="masculino">Masculino</label>
                <input type="radio" name="sexo" id="masculino" value="m" />
                <label for="femenino">Femenino</label>
                <input type="radio" name="sexo" id="femenino" value="f" />
            </div>
            <div>
                <label for="estadoCivil">
                    Estado Civil
                </label>
                <select name="estadoCivil" id="estadoCivil">
                    <option value="">-- Seleccione --</option>
                    <option value="1">Solter@</option>
                    <option value="2">Casad@</option>
                    <option value="3">Viud@</option>
                    <option value="4">Divorciad@</option>
                    <option value="5">Conviviente</option>
                </select>
            </div>
        </fieldset>
        <button>Registrar</button>
    </form>
</gch:base>