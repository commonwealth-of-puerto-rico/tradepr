<%--
  Created by IntelliJ IDEA.
  User: yamir
  Date: 5/13/15
  Time: 3:37 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>N&uacute;meros Ganadores</title>
</head>
<body>
<h2><a name='total'></a>      Total Trade</h2>
<table>
    <tr>
        <th width='10%' align='center' id='rnk'>Rank</th>
        <th width='30%' align='center' id='ctry'>Country</th>
        <th width='15%' align='center' id='exp'>Exports</th>
        <th width='15%' align='center' id='imp'>Imports</th>
        <th width='15%' align='center' id='trd'>Total Trade</th>
        <th width='15%' align='center' id='pct'>Percent of Total Trade</th>
    </tr>
    <tr>
        <td align='center' headers='tot rnk'><strong>---</strong></td>
        <td id='all'><strong>Total, All Countries</strong></td>
        <td align='right' headers='tot exp'><strong>     ${totalExports}</strong></td>
        <td align='right' headers='tot imp'><strong>     ${totalImports}</strong></td>
        <td align='right' headers='tot trd'><strong>     ${totalImports+totalExports}</strong></td>
        <td align='right' headers='tot pct'><strong> 100.0%</strong></td>
    </tr>
    <!--<tr>
        <td align='center' headers='top15 rnk'><strong>---</strong></td>
        <td id='Top15'><strong>Total, Top 15 Countries</strong></td>
        <td align='right' headers='Top15 exp'><strong>      94.0</strong></td>
        <td align='right' headers='Top15 imp'><strong>     151.5</strong></td>
        <td align='right' headers='Top15 trd'><strong>     245.5</strong></td>
        <td align='right' headers='Top15 pct'><strong>  74.2%</strong></td>
    </tr>-->>
<g:each var="variable" in="${totalTrade}">
    <tr>
        <td align='center' headers='cty1  rnk'>- </td>
        <td id='cty1'>${variable[0]}<br></td>
        <td align='right' headers='cty1  exp'>${variable[3]}</td>
        <td align='right' headers='cty1  imp'>${variable[1]}</td>
        <td align='right' headers='cty1  trd'>${variable[3]+variable[1]}</td>
        <td align='right' headers='cty1  pct'>--</td>
    </tr>
</g:each>

</table>
</body>
</html>