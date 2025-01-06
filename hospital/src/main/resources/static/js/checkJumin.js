/**
 * checkJumin.js
 */
$(function(){
	let juminChecked=false;
	$("#juminCheck").on("click",function(){
		$.ajax({
			type : "post",
			url : "/login/patientJuminCheck",
			data : {"patientJuminF" : $("#userJuminF").val()
			,"patientJuminB":$("#userJuminB").val()},
			dataType : "text",
			success : function(result){
				if(result=="1"){
					alert("이미 등록된 회원입니다. 회원번호 찾기 후 회원가입하여 주세요");
					location.href="/find/findPatientNum"
					juminCheked=false;
					console.log(juminChecked);
					
				}else{
					//$("#userJuminB").text("가입 가능한 회원");
					$("#patientJumin").text("확인완료");
					$("#patientJumin").css("color","blue");
					juminCheked=true;
					console.log(juminChecked);
				}
			},
			error:function(){
				alert("서버오류");
				juminChecked=false;
				console.log(juminChecked);
			}
			
		});
		
	});
	
	$("#frm").submit(function () {
		
	 	if(juminChecked==false){
			alert("주민등록번호 확인을 완료해주세요.");
			//$("#juminCheck").focus(); 
			return false;
		}
	});
	
});