<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <title>Moviefun</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <link href="../assets/css/movie.css" rel="stylesheet">
    <style>
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Moviefun</a>
        </div>
    </div>
</div>

<div class="container">

    <h1>Moviefun</h1>

    <h2>Album Details</h2>

    <dl>
        <dt>Title</dt>
        <dd>${requestScope.album.title}</dd>

        <dt>Artist</dt>
        <dd>${requestScope.album.artist}</dd>

        <dt>Year</dt>
        <dd>${requestScope.album.year}</dd>

        <dt>Cover</dt>
        <dd><img src="/albums/${requestScope.album.id}/cover" alt="Album Cover" class="cover"></dd>
    </dl>

    <h3>Change cover</h3>

    <form action="/albums/${requestScope.album.id}/cover" method="POST" enctype="multipart/form-data">
        <input type="file" name="file" accept=".gif,.jpg,.jpeg,.png">
        <input type="submit" value="Upload">
    </form>

    <nav>
        <a href="/albums">Back to list of albums</a>
    </nav>
</div>
<!-- /container -->
</body>
</html>
