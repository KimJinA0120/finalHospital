package hospital.service.info;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class SectionService {

	public void execute(Integer num, Model model) {
		String sectionName = null;
		String contents=null;
		String phone=null;
		String location=null;
		if(num!=null) {
			if(num==1) {
				sectionName="응급의학과";
				contents="응급의학과는 급성질환이나 손상으로 인한 신체의 이상에 대해 응급진료를 담당하며,\r\n"
						+ "외상, 뇌혈관질환, 심혈관질환 등 각종 응급질환에 철저히 대비하고 있습니다.";
				phone="031-111-1111";
				location="1층";
			}else if(num==2) {
				sectionName="마취통증의학과";
				contents="마취통증의학과는 수술 중 마취, 통증치료, 집중치료를 담당합니다.";
				phone="031-222-2222";
				location="2층";
			}else if(num==3) {
				sectionName="감염내과";
				contents="감염내과는 여러 감염질환의 진단 및 치료는 물론 다양한 발열질환의 원인을 규명하여 적절한 치료를 하는 곳입니다.";
				phone="031-333-3333";
				location="2층";
			}else if(num==4) {
				sectionName="재활의학과";
				contents="재활의학과는 약물치료와 운동치료, 물리치료, 작업치료, 인지재활치료 등 다각적으로 환자의 재활을 돕고 있습니다.";
				phone="031-444-4444";
				location="2층";
			}else if(num==5) {
				sectionName="이비인후과";
				contents="이비인후과는 귀와 코, 목 세분야에서 국내외적으로 많은 연구결과를 발표하고 있으며,\r\n"
						+ "환자 진료에 있어서도 국내 최고 수준의 실력을 자랑하고 있습니다.";
				phone="031-555-5555";
				location="2층";
			}else if(num==6) {
				sectionName="입원환자진료과";
				contents="";
				phone="031-666-6666";
				location="3층";
			}else if(num==7) {
				sectionName="피부과";
				contents="피부과는 치료가 까다로운 각종 피부질환을 탄탄한 기초 연구와 풍부한 임상경험을 통해 치료하여 그 성과를 널리 인정받고 있습니다.";
				phone="031-777-7777";
				location="3층";
			}else if(num==8) {
				sectionName="외상외과";
				contents="경기남부지역 중증외상환자 치료를 전담하며 지역외상진료체계 확립을 위해서 노력합니다.";
				phone="031-888-8888";
				location="3층";
			}else if(num==9) {
				sectionName="순환기내과";
				contents="순환기내과는 고혈압, 협심증, 심근경색증, 부정맥,\r\n"
						+ "심장판막질환, 선천성 심질환 등 심장혈관질환을 전문으로\r\n"
						+ "진료하며, 중재적 시술을 통해 치료효과를 극대화하고 있습니다.";
				phone="031-999-9999";
				location="3층";
			}else if(num==10) {
				sectionName="방사선종양학과";
				contents="방사선종양학 전문의, 방사선치료 계획과 시행을 위한 의학물리학자, 선량계획사, 방사선치료사, 전문 간호사들이 긴밀히 협업하여, 환자에게 최적의 방사선치료를 제공합니다.";
				phone="031-000-0000";
				location="3층";
			}
			
		}
		model.addAttribute("sectionName", sectionName);
		model.addAttribute("contents", contents);
		model.addAttribute("phone", phone);
		model.addAttribute("location", location);
		
	}

}
