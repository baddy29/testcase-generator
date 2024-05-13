$(document).ready(function() {
	$("#functionalityCode").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "/getFunctionalityCodeList",
				type : "POST",
				data : {
					moduleCode : $("#moduleCode").val(),
					term : $("#functionalityCode").val()
				},
				success : function(data) {
					response($.map(data, function(item) {
						return {
							label : item[0] + " | " + item[1],
							value : item[0]
						}
					}));
				}
			});
		},
		minLength : 2,
		select : function(event, ui) {
			var functionalityDesc = (ui.item.label).split("\|")[1];
			$("#functionalityDesc").val(functionalityDesc)
		}
	});

	$("#scenarioCode").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "/getScenarioCodeList",
				type : "POST",
				data : {
					functionalityCode : $("#functionalityCode").val(),
					term : $("#scenarioCode").val()
				},
				success : function(data) {
					response($.map(data, function(item) {
						return {
							label : item[0] + " | " + item[1],
							value : item[0],
							hdrId : item[2]
						}
					}));
				}
			});
		},
		minLength : 2,
		select : function(event, ui) {
			var scenarioDesc = (ui.item.label).split("\|")[1];
			$("#scenarioDesc").val(scenarioDesc);
			$("#hdrId").val(ui.item.hdrId);
		}
	});

});

function getTestCaseEntityGrid() {
	if($("#functionalityCode").val()=="" || $("#scenarioCode").val()==""){
		$.pnotify({
			title : "Error",
			text : "Please select Functionality Code and Scenario Code",
			type : "error",
			pnotify_animate_speed : .5,
			opacity : .8
		});
		return false;
	}else{
	var responseObject;
	var dynamicTableId = "testCaseEntityAdd";
	var responseObjectRows = "";
	var pagerElement = "pager12";
	$("#TestCaseEntityAddGrid")
			.html("<table id=\"testCaseEntityAdd\"></table>");
	jQuery("#" + dynamicTableId)
			.jqGrid(
					{
						url : '/getTestCaseEntityGrid',
						postData : {
							moduleCode : $("#moduleCode").val()
						},

						datatype : 'json',
						mtype : 'POST',
						colNames : [ 'Entity Type', 'Entity Code',
								'Entity Desc' ],
						colModel : [ {
							name : 'entityType',
							index : 'entityType',
							width : 170,
							editable : false,
							hidden : false
						}, {
							name : 'entityCode',
							index : 'entityCode',
							width : 170,
							editable : false,
							hidden : false
						}, {
							name : 'entityDesc',
							index : 'entityDesc',
							width : 170,
							editable : false,
							hidden : false
						} ],

						loadComplete : function() {
							var $this = $(this), ids = $this
									.jqGrid('getDataIDs'), i, l = ids.length;
							for (i = 0; i < l; i++) {
								var editparameters = {
									"keys" : false
								};
								$this.jqGrid('editRow', ids[i], editparameters);
							}
						},
						rowNum : 10000,
						datatype : 'json',
						pginput : true,
						viewrecords : true,
						multiselect : true,
						width : 1000,
						hidegrid : false,
						height : 500,
						gridview : true,
						subGrid : true,
						subGridOptions : {
							"plusicon" : "ui-icon-triangle-1-e",
							"minusicon" : "ui-icon-triangle-1-s",
							"openicon" : "ui-icon-arrowreturn-1-e",
							"reloadOnExpand" : false,
							"selectOnExpand" : true
						},
						subGridRowExpanded : function(subgrid_id, row_id) {
							getEntityDetails(subgrid_id, row_id);
						},
						caption : 'Test Case Entity'

					})
	}
}



function getEntityDetails(subgrid_id, row_id) {
	var mainRowId = row_id;
	var subgrid_table_id = 'table' + subgrid_id;
	var mainGridData = $('#testCaseEntityAdd').jqGrid("getRowData", row_id);
	var entityCode = mainGridData['entityCode'];
	$("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table>");
	jQuery("#" + subgrid_table_id)
			.jqGrid(
					{

						datatype : 'json',
						mtype : 'POST',
						url : '/getTestCaseEntityGridDetails',
						postData : {
							entityCode : entityCode
						},
						colNames : [ 'refDtlId', 'Attribute Code',
								'Attribute Desc', 'Attribute Possible Value',
								'Value Description',
								'Test Data Sequence',
								'Combinational Grouping No'],
						colModel : [ {
							name : 'refDtlId',
							index : 'refDtlId',
							width : 10,
							key:true,
							editable : false,
							hidden : true,
							editable : true,
							edittype : 'custom',
							editoptions : {
								custom_element : textFieldElement,
								custom_value : textFieldValue
							}
						}, {
							name : "entityAttributeCode",
							index : "entityAttributeCode",
							width : 100
						}, {
							name : "entityAttributeDesc",
							index : "entityAttributeDesc",
							width : 100
						}, {
							name : "attributePossibleValueCode",
							index : "attributePossibleValueCode",
							width : 100
						}, {
							name : "attributePossibleValueDesc",
							index : "attributePossibleValueDesc",
							width : 100
						}, {
							name : 'entitySequence',
							index : 'entitySequence',
							width : 100,
							editable : true,
							hidden : false,
							editable : true,
							edittype : 'custom',
							editoptions : {
								custom_element : textFieldElement,
								custom_value : textFieldValue
							}
						}, {
							name : "combinationalGroupingNo",
							index : "combinationalGroupingNo",
							width : 100,
							editable : true,
							edittype : 'custom',
							editoptions : {
								custom_element : textFieldElement,
								custom_value : textFieldValue
							}
						} ],
						loadComplete : function() {
							var $this = $(this), ids = $this.jqGrid('getDataIDs'), i, l = ids.length;
							for (i = 0; i < l; i++) {
								var editparameters = {"keys" : false};
								$this.jqGrid('editRow', ids[i], editparameters);
								if($("#combinationLogic").val()=="High Probability Combination"){
									$("#combinationalGroupingNo_"+ids[i]).attr("disabled",false);
								}else if($("#combinationLogic").val()=="All Possible"){
									$("#combinationalGroupingNo_"+ids[i]).attr("disabled",true);
								}else if ($("#combinationLogic").val()=="Entity Level"){
									$("#combinationalGroupingNo_"+ids[i]).attr("disabled",true);
								}
							}
						},
						caption : 'More Info',
						rowNum : 10000,
						datatype : 'json',
						pginput : true,
						viewrecords : true,
						multiselect : true,
						width : 900,
						hidegrid : true,
						height : '100%',
						gridview : true,
						autoencode : true,
						datatype : 'json'

					});

}

function saveTestCaseData() {
	if($("#functionalityCode").val()=="" || $("#scenarioCode").val()==""){
		$.pnotify({
			title : "Error",
			text : "Please select Functionality Code and Scenario Code",
			type : "error",
			pnotify_animate_speed : .5,
			opacity : .8
		});
		return false;
	}else{
	var mainGridId = jQuery("#testCaseEntityAdd").jqGrid('getGridParam', 'selarrrow');
	var subgridData;
	for (var i = 0; i < mainGridId.length; i++) {
		var mainid = mainGridId[i];
		var combinationalGroupingNo;
		var subGridId = jQuery("#tabletestCaseEntityAdd_" + mainid).jqGrid('getGridParam', 'selarrrow');
		if (subGridId.length > 0) {
			for (var p = 0; p < subGridId.length; p++) {
				var datarow = jQuery("#tabletestCaseEntityAdd_" + mainid).jqGrid('getRowData', subGridId[p]);
				if($("#combinationLogic").val()=="All Possible"){
					combinationalGroupingNo =	1;
				}else if ($("#combinationLogic").val()=="Entity Level"){
					combinationalGroupingNo =i+1;
				}else{
					combinationalGroupingNo = $('#'+'combinationalGroupingNo_'+subGridId[p]).val();
				}
				if (subgridData) {
					subgridData = subgridData+ ","+ JSON
									.stringify({
										refDtlId : $('#'+'refDtlId_'+subGridId[p]).val(),
										combinationalGroupingNo : combinationalGroupingNo,
										entitySequence : $('#'+'entitySequence_'+subGridId[p]).val(),
										hdrId : $('#hdrId').val(),
										activeFlag :"Y"
									});
				} else {
					subgridData = {
							refDtlId : $('#'+'refDtlId_'+subGridId[p]).val(),
							combinationalGroupingNo : combinationalGroupingNo,
							entitySequence : $('#'+'entitySequence_'+subGridId[p]).val(),
							hdrId : $('#hdrId').val(),
							activeFlag :"Y"
					};
					subgridData = JSON.stringify(subgridData);
				}
			}
		}

	}

	var subgridData = "[" + subgridData + "]";
	$('#testCaseData').val(subgridData);
	var form = document.getElementById("tcEventGroupAddForm");
	form.submit();
	}
}


function generateTestData() {
	if($("#functionalityCode").val()=="" || $("#scenarioCode").val()==""){
		$.pnotify({
			title : "Error",
			text : "Please select Functionality Code and Scenario Code",
			type : "error",
			pnotify_animate_speed : .5,
			opacity : .8
		});
		return false;
	}else{
		$.ajax({
			url : "/generateTestData",
			type : 'POST',
			data : {
				scenarioCode : $("#scenarioCode").val(),
				functionalityCode : $("#functionalityCode").val()
			},
			async : false,
			success : function(data1) {
				$.pnotify({
					title : "Success",
					text : "Test Data Generated Successfully",
					type : "sucesss",
					pnotify_animate_speed : .5,
					opacity : .8
				});
				$("#functionalityCode").val("");
				$("#scenarioCode").val("");
			},
			error : function(errorThrown) {
				console.log(errorThrown);
			}
		});
	}
	}


function setEntitySequence(){
	var mainGridId = jQuery("#testCaseEntityAdd").jqGrid('getGridParam', 'selarrrow');
	var subgridData;
	for (var i = 0; i < mainGridId.length; i++) {
		var mainid = mainGridId[i];
		var subGridId = jQuery("#tabletestCaseEntityAdd_" + mainid).jqGrid('getDataIDs');
		if (subGridId.length > 0) {
			for (var p = 0; p < subGridId.length; p++) {
				if($("#combinationLogic").val()=="High Probability Combination"){
					$("#combinationalGroupingNo_"+subGridId[p]).attr("disabled",false);
				}else if($("#combinationLogic").val()=="All Possible"){
					$("#combinationalGroupingNo_"+subGridId[p]).attr("disabled",true);
				}else if ($("#combinationLogic").val()=="Entity Level"){
					$("#combinationalGroupingNo_"+subGridId[p]).attr("disabled",true);
				}
			}
		}
	}
}

function textFieldElement(value, options,mainRowId) {
	var elemStr = '<div style="display:inline-block;">'	
			+ '<input type="text" id="' + options.name + "_"
			+ options.id.split("_")[0] + '" size="10" value="' + value
			+ '"  /><label class="gridAsterisk" id="' + options.name
			+ '_mandatory_' + options.id.split("_")[0]
			+ '"></label><br/><label class="error" id="' + options.name
			+ '_error_' + options.id.split("_")[0]
			+ '" ><jsp:text/></label></div>';
	if ($('#value').val() != undefined)
		elemStr = $('#value').val() + elemStr;
	return $(elemStr);
}

function textFieldValue(elem, operation, value) {
	var id = $("input", $(elem))[0].id;
	return $("#" + id).val();
}

function getGeneratedTestData(){

	if($("#functionalityCode").val()=="" || $("#scenarioCode").val()==""){
		$.pnotify({
			title : "Error",
			text : "Please select Functionality Code and Scenario Code",
			type : "error",
			pnotify_animate_speed : .5,
			opacity : .8
		});
		return false;
	}else{
	var responseObject;
	var dynamicTableId = "testDataGeneratedList";
	var responseObjectRows = "";
	var pagerElement = "pager12";
	$("#TestDataGeneratedGrid")
			.html("<table id=\"testDataGeneratedList\"></table>");
	jQuery("#" + dynamicTableId)
			.jqGrid(
					{
						url : '/getTestDataGeneratedList',
						postData : {
							functionalityCode : $("#functionalityCode").val(),
							scenarioCode : $("#scenarioCode").val()
						},

						datatype : 'json',
						mtype : 'POST',
						colNames : [ 'Functionality Code', 'Functionality Desc',
								'Scenario Code' , 'Scenario Desc', 'Active Status'],
						colModel : [ {
							name : 'functionalityCode',
							index : 'functionalityCode',
							width : 170,
							editable : false,
							hidden : false
						}, {
							name : 'functionalityDesc',
							index : 'functionalityDesc',
							width : 170,
							editable : false,
							hidden : false
						}, {
							name : 'scenarioCode',
							index : 'scenarioCode',
							width : 170,
							editable : false,
							hidden : false
						}, {
							name : 'scenarioDesc',
							index : 'scenarioDesc',
							width : 170,
							editable : false,
							hidden : false
						}, {
							name : 'activeFlag',
							index : 'activeFlag',
							width : 170,
							editable : false,
							hidden : false
						} ],

						loadComplete : function() {
							
						},
						rowNum : 10000,
						datatype : 'json',
						pginput : true,
						viewrecords : true,
						multiselect : true,
						width : 1000,
						hidegrid : false,
						height : 'auto',
						gridview : true,
						caption : 'Test Data List'

					})
	}

}