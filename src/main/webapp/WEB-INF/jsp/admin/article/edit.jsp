<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2017/5/31
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <%@ include file="/WEB-INF/jsp/admin/include/head.jsp" %>
</head>
<body>
<div id="wrapper">
    <!-- Navigation -->
    <%@ include file="/WEB-INF/jsp/admin/include/nav.jsp" %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">编辑文章</h1>

            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <form role="form" method="post" id="my-form" action="${appServer}/admin/article/doEdit">
                    <input type="hidden" name="articleId" value="${article.articleId}">
                    <input type="hidden" name="pageNo" value="${param.pageNo}">
                    <div class="form-group">
                        <label>标题</label>
                        <input class="form-control" name="articleTitle" value="${article.articleTitle}">
                        <p class="help-block">请输入标题</p>
                    </div>
                    <div class="form-group">
                        <label>二级标题</label>
                        <input class="form-control" name="articleSubtitle" value="${article.articleSubtitle}">
                        <p class="help-block">请输入二级标题</p>
                    </div>

                    <div class="form-group">
                        <label>封面</label>
                        <input class="form-control" name="articlePhotoPath" id="articlePhotoPath"
                               value="${article.articlePhotoPath}">
                        <p class="help-block">请输入封面图片地址</p>
                    </div>

                    <div class="form-group">
                        <label>正文</label>
                        <div id="editor">${article.articleContent}</div>
                        <p class="help-block">请输入正文</p>
                    </div>
                    <input type="hidden" value="" name="articleContent" id="articleContent">
                    <button type="button" class="btn btn-default" id="publish-button">修改</button>
                </form>
                <hr/>

                <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
                <script type="text/javascript" src="${staticServer}/static/vendor/wang/wangEditor.min.js"></script>
                <script type="text/javascript">
                    var E = window.wangEditor
                    var editor = new E('#editor')
                    // 配置服务器端地址
                    editor.customConfig.uploadImgServer = '${appServer}/admin/file/upload'
                    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
                    editor.customConfig.uploadImgHooks = {
                        before: function (xhr, editor, files) {
                            // 请求发送之前
                            console.log(files)
                        },
                        success: function (xhr, editor, result) {
                            // 上传成功之后
                            // result 是服务器端返回的结果
                            $("#articlePhotoPath").val(result.data[0]);
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
                    <%--editor.txt.html("${article.articleContent}");--%>

                </script>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">

        </div>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<%@ include file="/WEB-INF/jsp/admin/include/bodyfoot.jsp" %>


</body>
<script>
    $("#publish-button").click(function () {
        $("#articleContent").val(editor.txt.html())
        $("#my-form").submit();
    })

</script>
</html>
