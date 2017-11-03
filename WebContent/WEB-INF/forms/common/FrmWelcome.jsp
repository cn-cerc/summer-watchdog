<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="refresh" content="1">
<title>服务器监控平台</title>
<style>
    body,table{
        padding:0;
        margin:0;
    }
    table {
        border-collapse: collapse;
        border-spacing: 0;
        text-align:center;
        width:100%;
        border:1px solid #E4E9EC;
        color:#333;
    }
    table tr td,table tr th{
        padding-top:6px;
        padding-bottom:6px;
        border:1px solid #eee;
    }
    table tr th{
        background-color:#F2F2F2
    }
    table tbody tr:nth-child(2n){
        background-color:#F8FCFF;
    }
</style>
</head>
<body style="font-size: 2em;">
<div style="max-width:1200px;margin:0 auto;padding-top:50px;">
    <table border="1">
        <tr>
            <th>主机名</th>
            <th>状态</th>
            <th>异常次数</th>
            <th>检测地址</th>
        </tr>
        <tbody>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.status}</td>
                <td>${item.error}</td>
                <td><a target="_blank" href="${item.url}">${item.url}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
  </div>
</body>
</html>