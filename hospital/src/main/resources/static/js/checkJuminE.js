/**
 * checkJuminE.js
 */
$(function(){
	let juminChecked=false;
	$("#juminCheck").on("click",function(){
		$.ajax({
			type : "post",
			url : "/login/employeeJuminCheck",
			data : {"employeeJuminF" : $("#userJuminF").val()
			,"employeeJuminB":$("#userJuminB").val()},
			dataType : "text",
			success : function(result){
				if($("#userJuminF").val().trim()!="" && $("#userJuminB").val().trim()!=""){
					if(result=="1"){
						alert("이미 등록된 회원입니다. 회원번호 찾기 후 회원가입하여 주세요");
						$("#employeeJumin").text("");
						location.href="/find/findemployeeNum"
						juminCheked=false;
						console.log(juminChecked);
						
					}else{
						//$("#userJuminB").text("가입 가능한 회원");
						$("#employeeJumin").text("확인완료");
						$("#employeeJumin").css("color","blue");
						juminChecked=true;
						console.log(juminChecked);
					}
				}else{
					alert("주민번호 입력 후 이용해주세요");
					$("#userJuminF").focus();
				}
			},
			error:function(){
				alert("서버오류");
				$("#employeeJumin").text("");
				juminChecked=false;
				console.log(juminChecked);
			}
			
		});
		
	});
	
	$("#frm").submit(function () {
		
	 	if(juminChecked==false){
			alert("주민등록번호 확인을 완료해주세요.");
			$("#juminCheck").focus(); 
			return false;
		}
	});
	
});