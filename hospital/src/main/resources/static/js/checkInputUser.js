/**
 * check.js
 */
$(function(){
	$("#frm").submit(function(){
		if($("#userPw").val() != $("#userPwCon").val()){
			alert("비밀번호와 비밀번호확인이 다릅니다.");
			$("#userPw").val("");
			$("#userPwCon").val("");
			$("#userPw").focus();
			return false;
		} 
		if($("#userName").val()==null){
			alert("이름을 입력해주세요");
			$("#userName").focus();
			return false;
		}
		if($("#userJuminF").val()==null){
			alert("주민번호 앞자리를 입력해주세요");
			$("#userJuminF").focus();
			return false;
		}
		if($("#userJuminB").val()==null){
			alert("주민번호 뒷자리를 입력해주세요");
			$("#userJuminB").focus();
			return false;
		}
		if($("#userBirth").val()==null){
			alert("생년월일을 입력해주세요");
			$("#userBirth").focus();
			return false;
		}
		if($("#userId").val()==null){
			alert("아이디를 입력해주세요");
			$("#userId").focus();
			return false;
		}
		if($("#userPw").val()==null){
			alert("비밀번호를 입력해주세요");
			$("#userPw").focus();
			return false;
		}
		if($("#userPwCon").val()==null){
			alert("비밀번호확인을 입력해주세요");
			$("#userPwCon").focus();
			return false;
		}
		if($("#sample4_roadAddress").val()==null){
			alert("주소를 입력해주세요");
			$("#sample4_roadAddress").focus();
			return false;
		}
		if($("#userPhone").val()==null){
			alert("전화번호를 입력해주세요");
			$("#userPhone").focus();
			return false;
		}
		if($("#userEmail").val()==null){
			alert("이메일을 입력해주세요");
			$("#userEmail").focus();
			return false;
		}
	});
	
	
});

$(function(){
	$("#frmm").submit(function(){
		if($("#userName").val()==null){
			alert("이름을 입력해주세요");
			$("#userName").focus();
			return false;
		}
		if($("#userBirth").val()==null){
			alert("생년월일을 입력해주세요");
			$("#userBirth").focus();
			return false;
		}
		if($("#sample4_roadAddress").val()==null){
			alert("주소를 입력해주세요");
			$("#sample4_roadAddress").focus();
			return false;
		}
		
		var pattern=/^[0-9]$/;
		if($("#userPhone").val()==null){
			alert("전화번호를 입력해주세요");
			$("#userPhone").focus();
			return false;
		}/*else if($("#userPhone").val()!=pattern){
			alert("");
			return false;
		}*/
		
		if($("#userEmail").val()==null){
			alert("이메일을 입력해주세요");
			$("#userEmail").focus();
			return false;
		}
	});
	
});