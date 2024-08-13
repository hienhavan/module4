<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/12/2024
  Time: 10:07 AM
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
    <h1>Currency conversion</h1>

    <form action="tinhToan" method="post">

        <table>
            <tr>
                <td class="label"> Enter money:</td>
                <td><input type="text" name="money"></td>
            </tr>
            <tr>
                <td class="label"> Select currency:</td>
                <td>
                    <select name="op">
                        <option value="vnd">vnd</option>
                        <option value="usd">usd</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Tinh Toan"/></td>
                </td>

            </tr>
        </table>

    </form>
    <hr/>
    <h2>Result: ${result}</h2>
</div>
</body>
</html>