$(document).ready(function() {
	$( "#functionalityCode" ).autocomplete({
		source: '/getFunctionalityCodeList'+$("#functionalityCode").val()
});
	
	$( "#scenarioCode" ).autocomplete({
		source: '/getScenarioCodeList'+$("#scenarioCode").val()
});
});


function getEventGroupAddGrid(){
	var dynamicTableId ="eventGroupAddGrid";
	var responseObject;
	pagerElement="pager12";
	var responseObjectRows="";
	if ($('#responseJsonEventGroupDetail').val() != undefined && $('#responseJsonEventGroupDetail').val() != "")
		responseObject = jQuery.parseJSON($('#responseJsonEventGroupDetail').val());
	else
		responseObject = null;
	if (responseObject != null) {
		 responseObjectRows = responseObject.rows;
	}else{
		responseObjectRows = [];
	}

	$("#TestCaseEventGroupAddGrid").html(
			"<table id=\"eventGroupAddGrid\"></table><div id=\"pager12\"></div>");
	var searchType = $("#searchTypeSel").val();
	if (searchType == null || searchType == "") {
		searchType = 'A';
	}

	jQuery("#" + dynamicTableId)
			.jqGrid(
					{
						datatype : 'local',
						data : responseObjectRows,
						colNames : [
						        'eventGroupDtlId',
								'Event Code',
								'Event Action Code',
								'Event Action Parameters',
								'Event Sequence'
						],
						colModel : [
						{
							name : 'eventsGroupDtlId',
							index : 'eventsGroupDtlId',
							width : 50,
							editable : true,
							hidden : true
						},
						{
							name : 'eventCode',
							index : 'eventCode',
							width : 50,
							editable : true,
							edittype : 'text',
							hidden : false
						}, {
							name : 'eventActionCode',
							index : 'eventActionCode',
							width : 70,
							editable : true,
							edittype : 'text',
							hidden : false
						}, {
							name : 'eventActionParameter',
							index : 'eventActionParameter',
							width : 70,
							editable : true,
							edittype : 'text',
							hidden : false
						},
						{
							name : 'eventsGroupEventSeq',
							index : 'eventsGroupEventSeq',
							width : 70,
							editable : true,
							edittype : 'text',
							hidden : false
						}
						],

						loadComplete : function() {
							$('#responseJsonInvoiceManagementDetail').val("");
						},

						viewrecords : false,
						caption : 'Event Group Details',
						multiselect : true,
						pgInput : false,
						height : "auto",
						rowList: [10,20,30,40,50], 
						rowNum :100,
						width : 1000,
						sortable : true,
						pager : jQuery('#' + pagerElement),
						pginput : false,
						editurl : 'addRowToGrid',
						reloadAfterSubmit : false

					}).navGrid('#' + pagerElement, {
						add : false,
						edit : false,
						del : false,
						search : false,
						refresh :false
					}, {
						datatype : 'local'
					});
	
	jQuery("#" + dynamicTableId).jqGrid(
			'navButtonAdd',
			'#' + pagerElement,
			{
				caption : "",
				buttonicon : 'ui-icon-circle-plus',

				onClickButton : function(id) {
					var oldData = jQuery("#" + dynamicTableId).jqGrid('getDataIDs');
					id = oldData[oldData.length - 1];
					if (id) {
						id = parseInt(id);
						oldLastRowId = id;
						id = id + 1;
					} else {
						id = 0;
						oldLastRowId = 0;
					}
					var datarow = {
							eventsGroupDtlId : "",
							eventCode : "",
							eventActionCode : "",
							eventActionParameter : "",
							eventsGroupEventSeq : ""
						};
					jQuery("#" + dynamicTableId).jqGrid('addRowData', id, datarow);
					var editparameters = {
							"keys" : false
						};

						jQuery("#" + dynamicTableId).jqGrid('editRow',id, editparameters);
				},

				title : "Add Button",
				position : "first"

			});
	
	jQuery("#" + dynamicTableId).jqGrid(
			'navButtonAdd',
			'#' + pagerElement,
			{
				caption : "",
				buttonicon : 'ui-icon-trash',

				onClickButton : function(id) {
					var resultId = jQuery("#" + dynamicTableId).jqGrid('getGridParam', 'selarrrow');
					if (resultId && resultId.length > 0) {
						for (var i = 0; i < resultId.length; i++) {
							var datarow = jQuery("#" + dynamicTableId).jqGrid('getRowData',resultId[i]);
								jQuery("#" + dynamicTableId).jqGrid('delRowData',resultId[i]);
							
						}
					}
				},

				title : "Delete Button",
				position : "second"

			});
	
	jQuery("#" + dynamicTableId).jqGrid(
			'navButtonAdd',
			'#' + pagerElement,
			{
				caption : "",
				buttonicon : 'ui-icon-save',

				onClickButton : function(id) {
				},

				title : "Save Button",
				position : "third"

			});
	
			
}



function textFieldElement (value, options) {
    var elemStr = '<div style="display:inline-block;">' +
                  '<input type="text" id="'+options.name +"_"+ options.id.split("_")[0] + 
                  '" size="20" value="'+value+'"  /><label class="gridAsterisk" id="'+options.name + '_mandatory_' + options.id.split("_")[0] +
                  '"></label><br/><label class="error" id="'+options.name + '_error_' + options.id.split("_")[0] +
                  '" ><jsp:text/></label></div>';
   if($('#value').val() != undefined)
    elemStr = $('#value').val() + elemStr;
    return $(elemStr);
	}

function textFieldValue(elem, operation, value) {
    var id = $("input", $(elem))[0].id;
    return $("#"+id).val();
	} 