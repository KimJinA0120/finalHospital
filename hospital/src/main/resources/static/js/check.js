/**
 * check.js
 */
$(function(){
	let idChecked=false;
	let emailChecked=false;
	$("#userId").on("change keyup",function(){
		$.ajax({
			type : "post",
			url : "/login/userIdCheck",
			data : {"userId" : $("#userId").val()},
			dataType : "text",
			success : function(result){
				if(result == "1"){
					$("#idCheck").text("사용중인 아이디입니다.");
					$("#idCheck").css("color","red");
					idChecked=false;
				}else{
					$("#idCheck").text("사용가능한 아이디입니다.");
					$("#idCheck").css("color","blue");
					idChecked=true;
				}
			},
			error:function(){
				alert("서버오류");
				idChecked=false;
			}
		});
	});
	
	$("#userEmail").on("change keyup", function(){
		$.ajax({
			type:"post",
			url:"/login/userEmailCheck",
			dataType:"text",
			data:{"userEmail":$("#userEmail").val()},
			success:function(result){
				if(result == "1"){
					$("#emailCheck").text("사용중인 이메일입니다.");
					$("#emailCheck").css("color","red");
					emailChecked=false;
				}else{
					$("#emailCheck").text("사용가능한 이메일입니다.");
					$("#emailCheck").css("color","blue");
					emailChecked=true;
				}
			},
			error:function(){
				alert("서버 오류");
				emailChecked=false;
			}
		});
	});
	
	$("#frm").submit(function () {
		if(!idChecked){
			alert("사용가능한 아이디를 입력해주세요.");
			return false;
		}
		if(!emailChecked){
			alert("사용가능한 이메일을 입력해주세요.");
			return false;
		}
	});
	
});