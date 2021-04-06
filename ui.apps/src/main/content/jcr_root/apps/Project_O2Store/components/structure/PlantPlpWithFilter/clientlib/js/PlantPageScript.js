
      $(document).ready(function(){
		alert("invoked");
        $("#medicinal").hide();
        $("#foilage").hide();
        $("#flowering").hide();
        $("#RangeOne").hide();
        $("#RangeTwo").hide();
        $("#RangeThree").hide();
        $('#all-unchecked').hide();
        $('#all-unchecked1').hide();

<!-- unchecked  Function -->
$('#all-unchecked').click(function(){
        if(!$('input[name="medicine"]').is(':checked') && !$('input[name="flowers"]').is(':checked') && !$('input[name="foilage"]').is(':checked'))
        {
            $('#pricedropdown').show();
			$('#all-unchecked').hide();
            $("#allData").show();
        }else{
			alert('atleast one is checked');

        }
    });
<!-- unchecked  Function -->
$('#all-unchecked1').click(function(){
        if(!$('input[name="Range1"]').is(':checked') && !$('input[name="Range2"]').is(':checked') && !$('input[name="Range3"]').is(':checked'))
        {
            $('#plantdropdown').show();
			$('#all-unchecked1').hide();
            $("#allData").show();
        }else{
			alert('atleast one is checked');

        }
    });
$('input[type=checkbox][name="medicine"]').click(function(){
    $('#pricedropdown').hide();
	$("#allData").hide();
	$("#medicinal").show();
	$('#all-unchecked').show();
	if($(this).prop("checked") == false){
               $("#medicinal").hide();
}
});

$('input[type=checkbox][name="foilage"]').click(function(){
    $('#pricedropdown').hide();
	$("#allData").hide();
	$("#foilage").show();
	$('#all-unchecked').show();
	if($(this).prop("checked") == false){
               $("#foilage").hide();
}
}); 


$('input[type=checkbox][name="flowers"]').click(function(){
    $('#pricedropdown').hide();
	$("#allData").hide();
	$("#flowering").show();
	$('#all-unchecked').show();
	if($(this).prop("checked") == false){
               $("#flowering").hide();
}
}); 


$('input[type=checkbox][name="Range1"]').click(function(){
    $('#plantdropdown').hide();
	$("#allData").hide();
	$("#RangeOne").show();
	$('#all-unchecked1').show();
	if($(this).prop("checked") == false){
               $("#RangeOne").hide();
}
}); 
$('input[type=checkbox][name="Range2"]').click(function(){
     $('#plantdropdown').hide();
	$("#allData").hide();
	$("#RangeTwo").show();
	$('#all-unchecked1').show();
	if($(this).prop("checked") == false){
               $("#RangeTwo").hide();
}
}); 
$('input[type=checkbox][name="Range3"]').click(function(){
     $('#plantdropdown').hide();
	$("#allData").hide();
	$("#RangeThree").show();
	$('#all-unchecked1').show();
	if($(this).prop("checked") == false){
               $("#RangeThree").hide();
}
});
});
