<%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 2018/9/23
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/include/html_doctype.html" %>
<html>
<head>
    <title>积分列表</title>
    <%@include file="/commons/include/get.jsp" %>
</head>
<body>
<div class="panel">
    <div class="panel-top">
        <div class="tbar-title">
            <span class="tbar-label">积分列表</span>
        </div>
        <div class="panel-toolbar">
            <div class="toolBar">
                <div class="group"><a class="link search" id="btnSearch">查询</a></div>
            </div>
            <div class="toolBar" style="float: right;">
                <div class="group"><a class="link search"  href="${ctx}/datadriver/golden/consume.ht?scoreType=quanju">兑换全局币</a></div>
                <div class="l-bar-separator"></div>
                <div class="group"><a class="link add"  href="${ctx}/datadriver/golden/consume.ht?scoreType=gongxian">兑换贡献币</a></div>
                <div class="l-bar-separator"></div>
                <div class="group"><a class="link search"  href="${ctx}/datadriver/golden/consume.ht?scoreType=qiushi">兑换求实币</a></div>
                <div class="l-bar-separator"></div>
                <div class="group"><a class="link detail"  href="${ctx}/datadriver/golden/consume.ht?scoreType=chuangxin">兑换创新币</a></div>
            </div>
        </div>
        <div class="panel-search">
            <form id="searchForm" method="post" action="list.ht">
                <div class="row">
                    <span class="label">用户名:</span><input type="text" name="Q_userName_SL"  class="inputText" />
                    <span class="label">积分类型:</span>
                    <select name="Q_scoreType_S" class="select" value="${param['Q_scoreType_S']}">
                        <option value="">全部</option>
                        <option value="quanju" <c:if test="${param['Q_scoreType_S'] == 'quanju'}">selected</c:if>>全局</option>
                        <option value="qiushi" <c:if test="${param['Q_scoreType_S'] == 'qiushi'}">selected</c:if>>求实</option>
                        <option value="fengxian" <c:if test="${param['Q_scoreType_S'] == 'fengxian'}">selected</c:if>>奉献</option>
                        <option value="chuangxin" <c:if test="${param['Q_scoreType_S'] == 'chuangxin'}">selected</c:if>>创新</option>
                    </select>
                </div>
            </form>
        </div>
    </div>
    <div class="panel-body">
        <c:set var="checkAll">
            <input type="checkbox" id="chkall"/>
        </c:set>
        <display:table name="scoreList" id="scoreItem" requestURI="list.ht" sort="external" cellpadding="1" cellspacing="1" export="true"  class="table-grid">
            <display:column title="${checkAll}" media="html" style="width:30px;">
                <input type="checkbox" class="pk" name="bizDefId" value="${scoreItem.id}">
            </display:column>
            <display:column property="userName" title="用户名" sortable="true" sortName="userName" maxLength="80" style="text-align: center;"></display:column>
            <display:column property="scoreTotal" title="积分总量" sortable="true" sortName="scoreTotal" maxLength="80" style="text-align: center;"></display:column>
            <display:column property="udpTime" title="更新时间" sortable="true" sortName="udpTime" maxLength="80" style="text-align: center;"></display:column>
            <display:column property="scoreType" title="积分类型" sortable="true" sortName="scoreType" style="text-align: center;"></display:column>
            <display:column title="管理" media="html" style="width:260px; text-align: center;">
                <a href="del.ht?id=${scoreItem.id}" class="link del">删除</a>
                <a href="edit.ht?id=${scoreItem.id}" class="link edit">编辑</a>
                <a href="detail.ht?id=${scoreItem.id}&scoreType=${scoreItem.scoreType}" class="link detail">明细</a>
            </display:column>
        </display:table>
        <hotent:paging tableId="scoreItem"/>
    </div><!-- end of panel-body -->
</div> <!-- end of panel -->
</body>
</html>
