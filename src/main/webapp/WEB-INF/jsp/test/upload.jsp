<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2017/6/5
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/jsp/index/include/head.jsp" %>
</head>
<body>
<div id="editor">
    <p>欢迎使用</p>
</div>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="/static/vendor/wang/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    // 配置服务器端地址
    editor.customConfig.uploadImgServer = 'file/upload'
    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
    editor.customConfig.uploadImgHooks = {
        before: function (xhr, editor, files) {
            // 请求发送之前
            console.log(files)
        },
        success: function (xhr, editor, result) {
            // 上传成功之后
            // result 是服务器端返回的结果
            console.log(result)
        },
        fail: function (xhr, editor, result) {
            // 上传失败之后
            // result 是服务器端返回的结果
            console.log(result)
        },
        error: function (xhr, editor) {
            // 请求发生错误
        },
        timeout: function (xhr, editor) {
            // 请求超时
        }
    }
    // 或者 var editor = new E( document.getElementById('#editor') )
    editor.create()
</script>
</body>

</html>
