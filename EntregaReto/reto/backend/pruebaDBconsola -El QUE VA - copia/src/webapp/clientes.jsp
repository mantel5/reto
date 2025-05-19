<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clientes Registrados</title>
</head>
<body>
    <h2>Clientes Registrados</h2>
    <table border="1">
        <tr><th>Nombre</th><th>Email</th><th>Teléfono</th></tr>
        <%
            List<Map<String, String>> clientes = (List<Map<String, String>>) request.getAttribute("clientes");
            if (clientes != null) {
                for (Map<String, String> c : clientes) {
        %>
            <tr>
                <td><%= c.get("nombre") %></td>
                <td><%= c.get("email") %></td>
                <td><%= c.get("telefono") %></td>
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
