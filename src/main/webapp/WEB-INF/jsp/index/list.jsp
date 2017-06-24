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
    <title>yuyufeng的博客</title>
    <%@include file="/WEB-INF/jsp/index/include/head.jsp" %>
</head>
<body>
<!-- Navigation -->
<%@include file="/WEB-INF/jsp/index/include/nav.jsp" %>

<header class="intro-header" style="background-image: url('${staticServer}/static/vendor/cleanblog/img/home-bg.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>我的博客</h1>
                    <hr class="small">
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
            <ul class="pagination pagination-lg">
                <c:if test="${page.pageNum != 1}">
                    <li><a href="${appServer}/list/1">&laquo;</a></li>
                </c:if>
                <c:forEach items="${page.navigatepageNums}" var="c">
                    <c:if test="${c == page.pageNum}">
                        <li class="active">
                            <a>${c}</a>
                        </li>
                    </c:if>
                    <c:if test="${c != page.pageNum}">
                        <li>
                            <a href="${appServer}/list/${c}">${c}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.pageNum != page.pages}">
                    <li><a href="${appServer}/list/${page.pages}">&raquo;</a></li>
                </c:if>

            </ul>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/jsp/index/include/foot.jsp" %>
</body>
</html>
