<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<header class="intro-header" style="background-image: url('${staticServer}/static/vendor/cleanblog/img/home-bg.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>yuyu</h1>
                    <hr class="small">
                    <span class="subheading">yuyufeng的个人网站</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <c:forEach items="${page.list}" var="a">
                <div class="post-preview">
                    <a href="${appServer}/article/${a.articleId}">
                        <h2 class="post-title">
                            ${a.articleTitle}
                        </h2>
                        <h3 class="post-subtitle">
                                ${a.articleSubtitle}
                        </h3>
                    </a>
                    <p class="post-meta">Posted by <a href="#">yyf</a> ${a.articleTime}</p>
                </div>
                <hr>
            </c:forEach>

            <!-- Pager -->
            <ul class="pager">
                <li class="next">
                    <a href="${appServer}/list/1">Older Posts &rarr;</a>
                </li>
            </ul>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/jsp/index/include/foot.jsp" %>
</body>
</html>
