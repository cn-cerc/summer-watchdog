<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="refresh" content="1">
<title>服务器监控平台</title>
<style>
    *{
        padding:0;
        margin:0;
        box-sizing:border-box;
        -webkit-box-sizing:border-box;
    }
    h1,h2,h3,h4,h5,h6{
        font-size: 14px;
        font-weight: normal;
        color: #666;
    }
    body{
        background: #f4f9ff;
    }
    .main-con{
        width:1200px;
        margin:0 auto;
        padding-top:50px;
    }
    .main-con>h1{
        font-size: 50px;
        color: #0087DB;
        text-align: center;
    }
    .info-item{
        width: 100%;
        height: 500px;
        margin-top: 30px;
    }
    .info-item li{
        display:inline-block;
        width: 30%;
        height: 200px;
        border:1px solid #e6e6e6;
        border-radius:10px;
        -webkit-border-radius:10px;
        background: #fff;
        padding: 20px;
        float: left;
        margin: 0 1.5% 30px;
    }
    .info-item li .info-box{
        width: 100%;
        height: 100%;
    }
    .info-box>h1>span{
        font-size: 18px;
        color:#333;
        margin-right: 20px;
    }
    .info-box>h1>img{
        width: 18px;
        height: 18px;
    }
    .info-box>h2,.info-box>h3,.info-box>a{
        text-align: center;
    }
    .info-box>a{
        color: #3AAADD;
        font-size: 16px;
        text-decoration: none;
        margin-top: 10px;
        width: 100%;
        display: inline-block;
    }
    .info-box>h2{
        font-size: 58px;
        color:#0087DB;
        margin-bottom: 5px;
    }
    .info-box .error{
        color:#FF1000;
    }
</style>
</head>
<body>
<div class="main-con">
    <h1>服务器监控平台</h1>
    <ul class="info-item">
        <c:forEach items="${items}" var="item">
            <li>
                <div class="info-box">
                    <h1>
                        <span>${item.name}</span>
                        <c:choose>
                            <c:when test="${item.status == '正常'}">
                                <img src="${cdn}/img/ok.png"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${cdn}/img/error.png"/>
                            </c:otherwise>
                        </c:choose>
                        </h1>
                    <h2 class="${item.status == '正常' ? '' : 'error'}">${item.error}</h2>
                    <h3>异常次数</h3>
                    <a target="_blank" href="${item.url}">${item.url}</a>
                </div>
            </li>
        </c:forEach>
    </ul>
    
  </div>
</body>
</html>