<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SpringMVC 用户管理</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <h1>计算结果记录</h1>
    <hr/>

    <h3>所有记录 <a href="/" type="button" class="btn btn-primary btn-sm">进行计算</a></h3>

    <!-- 如果用户列表为空 -->
    <c:if test="${empty list}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>计算记录表为空，请<a
                href="/" type="button" class="btn btn-primary btn-sm">进行计算</a>
        </div>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty list}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>类型</th>
                <th>参数一</th>
                <th>参数二</th>
                <th>参数三</th>
                <th>参数四</th>
                <th>面积</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${list}" var="shape">
                <tr>
                    <td>${shape.stringType}</td>
                    <td>${shape.value1}</td>
                    <td>${shape.value2}</td>
                    <td>${shape.value3}</td>
                    <td>${shape.value4}</td>
                    <td>${shape.area}</td>
                    <td>

                        <a href="/delete/${shape.xuhao}" type="button"
                           class="btn btn-sm btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <h3>当前第<%= (int)request.getAttribute("page")+1%>页 / 共 <%= request.getAttribute("count")%>页</h3>
    <br>
    <h3><a id="btnprev" href="<%
            int prevPage = (int) request.getAttribute("page");
            if (prevPage>0){
                prevPage--;
                out.print("/records/"+prevPage);
            }

    %>" type="button" class="btn btn-primary btn-sm">上一页</a> <a id="btnnext" href="<%
            int nextPage = (int) request.getAttribute("page");
            int allPage = (int) request.getAttribute("count");
            if (nextPage<allPage-1){
                 nextPage++;
                 out.print("/records/"+nextPage);
            }
    %>" type="button" class="btn btn-primary btn-sm">下一页</a></h3>

</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>