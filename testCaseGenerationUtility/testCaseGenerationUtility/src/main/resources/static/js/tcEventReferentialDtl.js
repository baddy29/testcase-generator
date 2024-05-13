$(document).ready(function() {
	if ($("#searchActionLink_add").length > 0)
	{
	    $("#searchActionLink_add").click(function ()
	    {
	    	alert("hii");
	    });
	}
	$( "#eventCode" ).autocomplete({
		source: '/getEventCodeList'+$("#eventCode").val()
});
});