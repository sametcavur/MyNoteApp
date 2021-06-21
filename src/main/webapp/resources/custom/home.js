$(document).ready(function() {

	$.ajax({
		type: "POST",
		url: 'getnotes',
		success: function(data) {
			var list = "";
			$(data).each(function(i,val){
				
				list = list 
				+'<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12">'
				+'<h2 class="fh5co-article-title"><a href="addnote">'+ val.title +'</a></h2>'
				+'<h3><a href="home" style="color:#999999">'+ "Notu Sil" +' </a></h3>'
				+'<span class="fh5co-meta fh5co-date">'+ new Date(val.createDate).toLocaleDateString() +'</span>'
				+'</article>';
				
			});
			$("#list").html(list);
			
		}, error: function(data) {
			alert(data);
		}
	});
});