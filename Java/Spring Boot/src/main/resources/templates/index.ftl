<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>用户列表</title>
</head>
<body>
<table style="border: 1px solid blanchedalmond;">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>生日</th>
        <th>地址</th>
    </tr>
    <#if UserList?exists>
        <#list UserList as item>
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.birthday}</td>
        <td>${item.address}</td>
    </tr>
        </#list>
    </#if>
</table>
</body>
</html>