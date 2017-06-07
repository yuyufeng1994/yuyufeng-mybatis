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
    <%@include file="/WEB-INF/jsp/index/include/head.jsp" %>
</head>
<body>
<!-- Navigation -->
<%@include file="/WEB-INF/jsp/index/include/nav.jsp" %>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header" style="background-image: url('${article.articlePhotoPath}')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="post-heading">
                    <h1>${article.articleTitle}</h1>
                    <h2 class="subheading">${article.articleSubtitle}</h2>
                    <span class="meta">Posted by <a href="#">yyf</a> on ${article.articleTime}</span>
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
    </div>
</article>

<%@include file="/WEB-INF/jsp/index/include/foot.jsp" %>
</body>
</html>
