<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="commons.jsp" %>
<%@include file="index1.jsp" %>

<html>
<head>
<title>Test Case Event Group</title>
<script type="text/javascript" src="/js/tcEventGroup.js"></script>
</head>
<body onload="getEventGroupAddGrid();">
	<div class="container-fluid">
		<div class="jumbotron">
			<h3 class="text-center">Test Case Event Group</h3>
			<br>
			<form:form method="POST" class="form-inline" action="/tcEventGroupAdd" commandName="tcEventGroupHdr">
				<%-- <form:hidden path = "responseJsonEventGroupDetail" value = "%{responseJsonEventGroupDetail}" /> --%>
				<div class="container-fluid">
				<div class="well well-md">
					<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="eventsGroupCode">Event Group Code:</form:label>
										<form:input path="eventsGroupCode" id="eventsGroupCode"
											class="form-control" />
									</code>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="eventsGroupDesc">Event Group Desc:</form:label>
										<form:input path="eventsGroupDesc" id="eventsGroupDesc"
											class="form-control" />
									</code>
								</div>
							</div>
							<br> <br>
						</div>
					
					
					<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="functionalityCode">Functionality Code:</form:label>
										<form:input path="functionalityCode" id="functionalityCode"
											class="form-control" />
									</code>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="functionalityDesc">Functionality Desc:</form:label>
										<form:input path="functionalityDesc" id="functionalityDesc"
											class="form-control" />
									</code>
								</div>
							</div>
							<br> <br>
						</div>
					
					<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="scenarioCode">Scenario Code:</form:label>
										<form:input path="scenarioCode" id="scenarioCode"
											class="form-control" />
									</code>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="scenarioDesc">Scenario Desc:</form:label>
										<form:input path="scenarioDesc" id="scenarioDesc"
											class="form-control" />
									</code>
								</div>
							</div>
							<br> <br>
						</div>
					</div>
					
				</div>
				<div class="well well-md">
				<div class="row">
					<div id="TestCaseEventGroupAddGrid" align="center"></div>
				</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>