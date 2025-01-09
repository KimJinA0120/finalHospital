/**
 * check.js
 */
$(function(){
	$("#job_category").on("change", function() {
		
		// 선택된 옵션의 값 가져오기
		var selectedValue = $("#job_category option:selected").val();
		
		// 선택된 값이 비어있으면 AJAX 호출하지 않음
		if (selectedValue == "0") {
			alert("부서를 선택해주세요.");
			return false;
			
		} else {
			$.ajax({
				type : "post",
				url : "../employee/selectEmpSep",
				data : {"jobSep" : selectedValue},
				dataType : "text",
				success : function(result) {
					$("#empNum").val(result);
				},
				error: function() {
					alert("오류");
				}
			});
		}
	});

	$("#sectionSearch").click(function(){
		// 선택된 옵션의 값 가져오기
		var selectedValue = $("#job_category option:selected").val();
		
		// 선택된 값이 비어있으면 AJAX 호출하지 않음
		if (selectedValue == "0") {
			alert("부서를 선택해주세요.");
			return false;
			
		} else {
			if(selectedValue=="mdt_"){
				selectedValue="med";
			} else if(selectedValue=="emp_"){
				selectedValue="admin";
			}
		window.open("sectionSearch?kind="+selectedValue,"소속과 검색",
				"width=620,height=400,left=30,top=50")
		}
	});

	$("#frm").submit(function(){
		if($("#position").val().trim() === ""){
			alert("직무를 입력해주세요");
			$("#position").focus();
			return false;
		}
		if($("#sectionNum").val().trim() === ""){
			alert("소속과를 입력해주세요");
			$("#sectionNum").focus();
			return false;
		}
		if($("#empHiredate").val().trim() === ""){
			alert("입사일을 입력해주세요");
			$("#empHiredate").focus();
			return false;
		}
	});
});