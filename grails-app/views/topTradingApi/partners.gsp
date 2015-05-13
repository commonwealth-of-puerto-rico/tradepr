<%--
  Created by IntelliJ IDEA.
  User: yamir
  Date: 5/13/15
  Time: 3:44 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

    <table>
    <g:each var="year" in="${years}">
        <g:each var="month" in="${12..1}">
            <g:if test="${month < new Date().getMonth()}">
                <tr>
                    <td><g:link action="topTrading" params="[year: year, month: String.format('%02d', month)]">${year.value}/${String.format("%02d",month)}</g:link></td>
                </tr>
            </g:if>
        </g:each>
    </g:each>
    </table>
</body>
</html>