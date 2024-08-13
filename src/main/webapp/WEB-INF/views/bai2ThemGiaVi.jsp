<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/13/2024
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        .label.input.select.option {
            font-size: 30px;
            color: red;
        }

        .nen {
            width: 40%;
            height: auto;
            background: bisque;
            border: 1px solid rosybrown

        }
    </style>
</head>
<body>
<div class="nen">
    <h1>Select the fuel</h1>

    <form action="SaveNL" method="post">

        <table>
            <tr>
                <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="OK"/></td>
                </td>

            </tr>
        </table>

    </form>
    <hr/>
    <h2>Result: ${data}</h2>
</div>
</body>
</html>