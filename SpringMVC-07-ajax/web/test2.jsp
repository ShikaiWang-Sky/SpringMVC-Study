<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2020/9/11
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.min.js"></script>

    <script>
        //最外面的function保证窗口一打开里面的函数就运行, 一定要写!
        $(function () {
            $("#btn").click(function () {
                /*
                $.post(url, param[可以省略], success
                 */
                $.post("${pageContext.request.contextPath}/a2",function (data) {
                    //console.log(data);
                    let html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].sex + "</td>" +
                            "</tr>"
                    }
                    $("#content").html(html);
                });
            })
        });
    </script>

<body>

<input type="button" value="加载数据" id="btn">

<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
        <%--数据: 后台--%>
    </tbody>
</table>

</body>
</html>
