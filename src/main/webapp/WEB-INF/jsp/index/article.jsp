<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2017/6/2
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.articleTitle}</title>
    <%@include file="/WEB-INF/jsp/index/include/head.jsp" %>
    <style>
        .font-cor{
            /*background-color:#FFFFFF;*/
            /*color:#333;*/
        }
    </style>
</head>
<body>
<!-- Navigation -->
<%@include file="/WEB-INF/jsp/index/include/nav.jsp" %>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header" style="background-image: url('${article.articlePhotoPath}')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-2">
                <div class="post-heading" >
                    <h1><span class="font-cor">${article.articleTitle}</span></h1>
                    <h2 class="subheading font-cor"><span>${article.articleSubtitle}</span></h2>
                    <span class="meta font-cor" >Posted by <a href="#">yyf</a> on ${article.articleTime}</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Post Content -->
<article>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                ${article.articleContent}
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <!--PC版-->
                <div id="SOHUCS" sid="article${article.articleId}"></div>
                <script charset="utf-8" type="text/javascript"
                        src="https://changyan.sohu.com/upload/changyan.js"></script>
                <script type="text/javascript">
                    window.changyan.api.config({
                        appid: 'cyt41ItsL',
                        conf: 'prod_892fe75589e3056d5f79d26919f03104'
                    });
                </script>
            </div>
        </div>
    </div>
</article>


<%@include file="/WEB-INF/jsp/index/include/foot.jsp" %>
</body>
</html>
