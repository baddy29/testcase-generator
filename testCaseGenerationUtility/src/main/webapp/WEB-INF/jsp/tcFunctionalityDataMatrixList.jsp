<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="commons.jsp"%>
<html>
<head>
<title>Functionality-Test Case Data Matrix</title>
<script type="text/javascript" src="/js/tcFunctionalityDataMatrix.js"></script>
<script>
//$.pnotify.defaults.styling = 'bootstrap3'; // Bootstrap version 3
//$.pnotify.defaults.icons = 'bootstrap3';
//$.jgrid.defaults.styleUI = 'Bootstrap4';
//$.jgrid.defaults.iconSet = 'Octicons';
//$.pnotify.defaults.styling = 'bootstrap4';
</script>  
</head>
<body onload="">
	<div class="container-fluid">
		<div class="jumbotron">
			<h3 class="text-center">Functionality-Test Case Data Matrix</h3>
			<br>
			<form:form method="POST" class="form-inline" id="testDataListForm"
				action="/executeOperationOnTestData" commandName="tcInputMappingMatrixHdr">
				<div class="container-fluid">
					<div class="well well-md">
					<div class="row">
							<div class="col-md-6">
							<div class="form-group">
							<code>
							<form:label path="moduleCode" class="caption">Module:</form:label>
								<form:select path="moduleCode" class="form-control">
									<form:options items="${moduleCodeList}" />
								</form:select>
								</code>
								</div>
							</div>
							<br> <br>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="functionalityCode" class="caption">Functionality Code:</form:label>
										<form:input path="functionalityCode" id="functionalityCode" required="required"
											class="form-control" />
									</code>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="functionalityDesc" class="caption">Functionality Desc:</form:label>
										<form:input path="functionalityDesc" id="functionalityDesc" disabled="true"
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
										<form:label path="scenarioCode" class="caption">Scenario Code:</form:label>
										<form:input path="scenarioCode" id="scenarioCode" required="required"
											class="form-control" />
									</code>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="scenarioDesc" class="caption">Scenario Desc:</form:label>
										<form:input path="scenarioDesc" id="scenarioDesc" disabled="true"
											class="form-control" />
									</code>
								</div>
							</div>
							<br> <br>
						</div>
						
						<div class="row">
							<div class="btn-group btn-group-md pull-right">
								<button type="button" class="btn btn-info btn-md" onclick=""
									style="float: right;">Clear</button>
								<button type="button" class="btn btn-info btn-md" onclick="getGeneratedTestData();"
									style="float: right;">Search</button>
								</div>
								</div>	
								<br>
								<div class="row">
							<div class="btn-group btn-group-md pull-right">
								<button type="button" class="btn btn-info btn-md" onclick=""
									style="float: right;">Deactivate</button>	
								<button type="button" class="btn btn-info btn-md" onclick=""
									style="float: right;">Modify</button>
								<button type="button" class="btn btn-info btn-md" onclick=""
									style="float: right;">Add</button>			
							</div>
						</div>
					</div>
				</div>
				<div class="well well-md">
					<div class="row">
						<div id="TestDataGeneratedGrid" align="center"></div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>