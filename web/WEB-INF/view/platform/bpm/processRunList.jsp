<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/include/html_doctype.html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程实例管理</title>
<%@include file="/commons/include/get.jsp" %>
</head>
<body>
			<div class="panel panel-default">
				<div class="panel-heading" style="background:#76B0EA">
					<div class="panel-title" style="color:#ffffff;font-weight:bold;font-size:15px;">
					流程实例管理列表
					</div>
				</div>
				<div class="panel-body">
					<div class="panel-toolbar">
						<div class="toolBar">
							<div class="group"><a class="link search" id="btnSearch">查询</a></div>
							<div class="l-bar-separator"></div>
							<div class="group"><a class="link del"  action="del.ht">删除</a></div>
						</div>	
					</div>
					<div class="panel-search">
							<form id="searchForm" method="post" action="list.ht">
									<div class="row">
										<span class="label">流程定义名称:</span><input type="text" name="Q_processName_SL"  class="inputText" value="${param['Q_processName_SL']}"/>
										<span class="label">流程实例标题:</span><input type="text" name="Q_subject_SL"  class="inputText" value="${param['Q_subject_SL']}"/>
										<span class="label">创建时间 从:</span> <input  name="Q_begincreatetime_DL"  class="inputText date" value="${param['Q_begincreatetime_DL']}"/>
										<span class="label">至: </span><input  name="Q_endcreatetime_DG" class="inputText date" value="${param['Q_endcreatetime_DG']}">
										<span class="label">状态:</span>
										<select name="Q_status_SN" value="${param['Q_status_SN']}">
											<option value="">所有</option>
											<option value="1" <c:if test="${param['Q_status_SN'] == 1}">selected</c:if>>正在运行</option>
											<option value="2" <c:if test="${param['Q_status_SN'] == 2}">selected</c:if>>结束</option>
										</select>
									</div>
							</form>
					</div>		
				</div>
				<div class="panel-footer">
					
				    	<c:set var="checkAll">
							<input type="checkbox" id="chkall"/>
						</c:set>
					    <display:table name="processRunList" id="processRunItem" requestURI="list.ht" sort="external" cellpadding="1" cellspacing="1" export="true"  class="table table-bordered table-hover">
							<display:column title="${checkAll}" media="html" style="width:30px;" class="active">
								  	<input type="checkbox" class="pk" name="runId" value="${processRunItem.runId}">
							</display:column>
							<display:column property="subject" title="流程实例标题" href="get.ht" paramId="runId" paramProperty="runId" maxLength="18" sortable="true" sortName="subject" style="text-align:left" class="active">
								
							</display:column>
							<display:column property="processName" title="流程定义名称" sortable="true" sortName="processName" style="text-align:left" class="active"></display:column>
							<display:column property="creator" title="创建人" sortable="true" sortName="creator" style="text-align:left" class="active"></display:column>
							<display:column  title="创建时间" sortable="true" sortName="createtime" class="active">
								<fmt:formatDate value="${processRunItem.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</display:column>
							<display:column  title="结束时间" sortable="true" sortName="endTime" class="active">
								<fmt:formatDate value="${processRunItem.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</display:column>
							<display:column title="持续时间" sortable="true" sortName="duration" class="active">
								${f:getTime(processRunItem.duration)}
							</display:column>
							<display:column title="状态" sortable="true" sortName="status" class="active">
								<c:choose>
									<c:when test="${processRunItem.status==1}">
										<span class='green'>正在运行</span>
									</c:when>
									<c:when test="${processRunItem.status==2}">
										<span class="red">结束</span>
									</c:when>
									<c:when test="${processRunItem.status==3}">
										<span class="brown">人工结束</span>
									</c:when>
									
								</c:choose>
							</display:column>
							<display:column title="管理" media="html" style="width:240px" class="active">
								<f:a alias="delRun" href="del.ht?runId=${processRunItem.runId}" css="link del">删除</f:a>
								<a href="${ctx}/platform/bpm/bpmRunLog/list.ht?runId=${processRunItem.runId}" class="link log">操作日志</a>
								<a href="${ctx}/cloud/toolInfOfProcess/get.ht?runId=${processRunItem.runId}" class="link detail">工具结果数据查看</a>
							</display:column>
						</display:table>
						<hotent:paging tableId="processRunItem"/>
					
				</div><!-- end of panel-body -->				
			</div> <!-- end of panel -->
</body>
</html>


