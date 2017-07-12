<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>图形面积计算</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <script>
        function choose(index) {
            var obj = document.getElementById("selector");
            obj.options[index].selected = true;  //保持选中状态
            switch (index) {
                case 0:
                    //输入三角形状
                    //显示项目
                    document.getElementById("div1").style.display = "inline";
                    document.getElementById("div2").style.display = "inline";
                    document.getElementById("div3").style.display = "inline";
                    document.getElementById("div4").style.display = "none";
                    //修改文字
                    document.getElementById("label1").innerHTML = "第一条边长度";
                    document.getElementById("label2").innerHTML = "第二条边长度";
                    document.getElementById("label3").innerHTML = "第三条边长度";
                    break;
                case 1:
                    //矩形
                    //显示项目
                    document.getElementById("div1").style.display = "inline";
                    document.getElementById("div2").style.display = "inline";
                    document.getElementById("div3").style.display = "none";
                    document.getElementById("div4").style.display = "none";
                    //修改文字
                    document.getElementById("label1").innerHTML = "矩形长度:";
                    document.getElementById("label2").innerHTML = "矩形宽度:";

                    break;
                case 2:
                    //圆形
                    //显示项目
                    document.getElementById("div1").style.display = "inline";
                    document.getElementById("div2").style.display = "none";
                    document.getElementById("div3").style.display = "none";
                    document.getElementById("div4").style.display = "none";
                    //修改文字
                    document.getElementById("label1").innerHTML = "圆形半径:";
                    break;
                case 3:
                    //梯形
                    //显示项目
                    document.getElementById("div1").style.display = "inline";
                    document.getElementById("div2").style.display = "inline";
                    document.getElementById("div3").style.display = "inline";
                    document.getElementById("div4").style.display = "none";
                    //修改文字
                    document.getElementById("label1").innerHTML = "上底长度:";
                    document.getElementById("label2").innerHTML = "下底长度:";
                    document.getElementById("label3").innerHTML = "高度:";
                    break;

            }
        }
    </script>
</head>
<body>
<div class="container">
    <h1>图形面积计算</h1>
    <hr/>
     <a href="/records/0" type="button" class="btn btn-primary btn-sm">查看所有记录</a>
    <br>
    <br>
    <form:form action="/calcu" method="post" commandName="shape" role="form">
        <div class="btn-group">
            <label>图形选择:</label>
            <br/>
            <div class="form-group">
                <select id="selector" class="form-control" name="type" onchange="choose(this.selectedIndex)">
                    <option value="1">三角形</option>
                    <option value="2">矩形</option>
                    <option value="3">圆形</option>
                    <option value="4">梯形</option>
                </select>
            </div>
        </div>
        <br>
        <div class="form-group" id="div1">
            <label id="label1">参数1:</label>
            <input type="number" class="form-control" id="value1" name="value1"/>
        </div>
        <div class="form-group" id="div2">
            <label id="label2">参数2:</label>
            <input type="number" class="form-control" id="value2" name="value2"/>
        </div>
        <div class="form-group" id="div3">
            <label id="label3">参数3:</label>
            <input type="number" class="form-control" id="value3" name="value3"/>
        </div>
        <div class="form-group" id="div4">
            <label id="label4">参数4:</label>
            <input type="number" class="form-control" id="value4" name="value4"/>
        </div>
        <br>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">计算</button>
        </div>
    </form:form>
</div>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
    choose(0);
</script>
</body>
</html>