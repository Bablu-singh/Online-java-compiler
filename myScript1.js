function compile(){
	if(document.getElementById("code").value==""){
		alert("Please Write your code");
		$('#code').focus();
	}
	else{
		var url="compile?className="+document.getElementById("class").value+"&code="+document.getElementById("code").value;
		$.ajax({
			url:url
		}).done(function(response){
			$('textarea#code1').val(response);
		});
	}
}
function run(){
	var url="run?className="+document.getElementById("class").value;
	$.ajax({
		url:url
	}).done(function(response){
		$('textarea#code1').val(response);
	});
}
function blank(){
	document.getElementById("code").value="";
	document.getElementById("code").value="";
	document.getElementById("code").value="";
}
function set(){
	if(document.getElementById("class").value==""){
	$('#class').focus();
//	alert("Somthing Went Wrong");
	}
	else
	{
		var cd="class "+document.getElementById("class").value+"\n"+"{"+"\n"+"public static void main(String[] args){"+"\n\n\n\n"+"   }"+"\n"+"}"
		$('textarea#code').val(cd);
	}	 
}