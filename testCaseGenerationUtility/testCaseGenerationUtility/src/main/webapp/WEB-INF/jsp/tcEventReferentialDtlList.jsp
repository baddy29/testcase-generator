<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Test Case Generation</title>
<script type="text/javascript" src="/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/grid.locale-en.js"></script>
<script type="text/javascript" src="/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="/js/prefixfree.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui.js"></script>
<script type="text/javascript" src="/js/tcEventReferentialDtl.js"></script>

<link href="css/ui.jqgrid.css" rel="stylesheet" />
<link href="css/jquery.autocomplete.css" rel="stylesheet" />
<link href="css/ui.multiselect.css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/jquery-ui.css" rel="stylesheet" />
<link href="css/ui.multiselect.css" rel="stylesheet" />
<link href="css/jquery.searchFilter.css" rel="stylesheet" />
<link href="css/grid.base.js" rel="stylesheet" />
<link href="css/grid.common.js" rel="stylesheet" />
<link href="css/grid.inlinedit.js" rel="stylesheet" />
<link href="css/grid.formedit.js" rel="stylesheet" />
<link href="css/grid.subgrid.js" rel="stylesheet" />
<link href="css/grid.custom.js" rel="stylesheet" />
<link href="css/jquery.fmatter.js" rel="stylesheet" />
<link href="css/jquery.searchFilter.js" rel="stylesheet" />
<link href="css/grid.jqueryui.js" rel="stylesheet" />
<link href="css/grid.celledit.js" rel="stylesheet" />
<link href="css/gridStyles.css" rel="stylesheet" />
<link href="css/jquery-ui-1.8.12.css" rel="stylesheet" />
<link href="css/myStyle.css" rel="stylesheet" />

</head>
<body>
	<div class="container-fluid">
		<div class="jumbotron">
			<h3 class="text-center">Test Case Event</h3>
			<br>
			<form:form method="POST" class="form-inline"
				action="/tcEventReferentialDtlList"
				commandName="tcEventReferentialDtl">

				<div class="container-fluid">
					<div class="row">
						<div class="well well-md">
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="eventCode">Event Code:</form:label>
										<form:input path="eventCode" id="eventCode"
											class="form-control" />
									</code>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<code>
										<form:label path="eventActionCode">Event Action Code:</form:label>
										<form:input path="eventActionCode" id="eventActionCode"
											class="form-control" />
									</code>
								</div>
							</div>
							<br>
							<br>
						</div>
					</div>
					<div class="row">
						<button type="button" class="btn btn-info btn-md" onclick=""
							style="float: right;">Search</button>
					</div>
					<br>
					<div class="row">
						<div class="btn-group btn-group-sm pull-right">
							<a id="searchActionLink_add" href="#." class="btn btn-primary">Add</a>
							<a id="searchActionLink_edit" href="#." class="btn btn-primary">Modify</a>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>