/**
 * getCss.js
 */
/// 직원용 헤더
$(function(){
	$.ajax({
		type : "get",
		url: "../getHeader",
		dataType:"html",
		success:function(result){
			$("#getHeader").html(result);
		},
		error:function(){
			alert("서버오류");
		}
	});
	
});

/// 환자용 헤더
$(function(){
	$.ajax({
		type : "get",
		url: "../getPatHeader",
		dataType:"html",
		success:function(result){
			$("#getHeader").html(result);
		},
		error:function(){
			alert("서버오류");
		}
	});
	
});


//// 헤더가 직원용이면 직원색으로, 환자용이면 환자색으로 바뀜
$(function(){
	$.ajax({
			type : "get",
			url: "../getFooter",
			dataType:"html",
			success:function(result){
				$("#getFooter").html(result);
			},
			error:function(){
				alert("서버오류");
			}
		});
});