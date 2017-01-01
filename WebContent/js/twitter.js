$(function() {
	// global variable keyword having value 'romance'
	var keyword = "romance";

	// get category from hash. It is to load same data even in refresh
	if (window.location.hash) {
		keyword = window.location.hash.substring(1);
	}

	// default ajax call for keyword 'romance'
	callAjax(keyword);
	/*
	 * $.get("TwitterServlet", { "query" : keyword
	 * }).done(ajaxSuccess).fail(ajaxFailure);
	 */
	 

	// remove 'active' class from all 'category' list
	$("li").removeClass("active");

	// add active class in the recently clicked category while reloading
	$("#" + keyword).parent("li").addClass("active");

	// ajax call when particular 'category' is clicked
	$(".keyword").click(function() {
		$(".keyword").parent("li").removeClass("active");
		$(this).parent("li").addClass("active");
		$("#content-here").empty();
		keyword = $(this).data("value");

		var id = $(this).attr("id");
		window.location.hash = id;
		
		callAjax(keyword);
		/*
		 * $.get("TwitterServlet", { "query" : keyword
		 * }).done(ajaxSuccess).fail(ajaxFailure);
		 */
		 
	});
	
	// ajax call
	function callAjax(keyword) {
		$.get("TwitterServlet", {
			"query" : keyword
		}).done(ajaxSuccess).fail(ajaxFailure);
	}

	// success function for ajax request
	function ajaxSuccess(myStatusData) {
		$.each(myStatusData, function(index, value) {
			var mydiv = $('<div>').addClass("tweet-block");
			mydiv.append($('<img>', {
				src : value.imageURL,
				css : {
					height : "350px",
					width : "300px"
				}
			})).append($("<div>", {
				text : value.text,
				'class' : 'tweet-contnet'
			}));

			$("#content-here").append($('<a>', {
				href : value.link
			}).append(mydiv));
		});
	}

	// failure function for ajax request
	function ajaxFailure(xhr, ststus, exception) {
		console.log(xhr, ststus, exception);
	}
	
	// handle scroll event
	$(window).scroll(function() {
			console.log("scrolling starts");
			if ($(window).scrollTop() == $(document).height() - $(window).height()) {
				console.log("proceed..");
				callAjax(keyword);
			}
	});
});