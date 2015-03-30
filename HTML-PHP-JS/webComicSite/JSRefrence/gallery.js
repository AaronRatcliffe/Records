$(document).ready(function(){

	$(function(){
		
		$(".pic").click(function(){
			$("#before").attr("src", $(this).attr("src"));
			$("#before").attr("id", "after");
		});
		
		$("#after,#before").click(function(){
			$("#after").attr("src", " ");
			$("#after").attr("id", "before");
		});
	});
});