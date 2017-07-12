<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>计算结果显示</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>计算结果</h1>
    <hr/>
    <table class="table table-bordered table-striped">
        <tr>
            <th>类型</th>
            <td>${result.stringType}</td>
        </tr>
        <tr>
            <th>参数一</th>
            <td>${result.value1}</td>
        </tr>
        <tr>
            <th>参数二</th>
            <td>${result.value2}</td>
        </tr>
        <tr>
            <th>参数三</th>
            <td>${result.value3}</td>
        </tr>
        <tr>
            <th>参数四</th>
            <td>${result.value4}</td>
        </tr>
        <tr>
            <th>面积</th>
            <td>${result.area}</td>
        </tr>
    </table>
    <a href="/" type="button" class="btn btn-primary btn-sm">返回计算</a>
    <a href="/records/0" type="button" class="btn btn-primary btn-sm">历史纪录</a>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>