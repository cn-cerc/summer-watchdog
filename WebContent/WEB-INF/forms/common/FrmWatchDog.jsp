<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="refresh" content="5">
<title>首页</title>
</head>
<body style="font-size: 2em;">
    <div style="text-align: center; padding-top: 2em;">
        <div>服务器一状态：${flag1 ? '正常' : '异常'}
        </div>
    </div>
    <div style="text-align: center; padding-top: 2em;">
        <div>服务器二状态：${flag2 ? '正常' : '异常'}
        </div>
    </div>
</body>
</html>