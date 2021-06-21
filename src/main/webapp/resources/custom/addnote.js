/**
 * 
 */
  function addnote(){
	var param = {
		title:$("#noteTitle").val(),
		content:$("#noteContent").val()
	}
	
	var setData = JSON.stringify(param);
	
	$.ajax({
		type : "POST",
		contentType: "application/json;charset=UTF-8",
		url:'addnote',
		data : setData,
		success:function(data){
			alert(data);
			console.log("success");
		},error:function(error){
			alert(error);	
		}
	});
}
