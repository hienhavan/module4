<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/13/2024
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        .label.input.select.option{
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
    <h1>A Simple Calculator</h1>

    <form action="hienThiTinhToan" method="post">

        <table>
            <tr>
                <td class="label"> Enter operand 1:</td>
                <td><input type="text" name="num1"></td>
            </tr>
            <tr>
                <td class="label"> Enter operand 2:</td>
                <td><input type="text" name="num2"></td>
            </tr>
            <tr>
                <td class="label"> Select operation:</td>
                <td>
                    <select name="op">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value=":">:</option>

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
    <h2>Result: ${data}</h2>
</div>
</body>
</html>
