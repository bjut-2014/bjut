<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav-container">
    <a href="index" class="nav-title fl">嵌入式实训平台</a>
    <div class="nav-right fr">
        <span class="nav-hello">您好，${session.currentUser.name}</span>
        <a href="logout" class="logout"><span>注销</span></a>
    </div>
</div>