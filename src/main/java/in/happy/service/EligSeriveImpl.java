package in.happy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import in.happy.binding.EligResponse;
import in.happy.entity.CitizenAppEntity;
import in.happy.entity.DcCaseEntity;
import in.happy.entity.DcChildrenEntity;
import in.happy.entity.DcIncomeEntity;
import in.happy.entity.PlanEntity;
import in.happy.repo.CitizenAppRepo;
import in.happy.repo.DcCaseRepo;
import in.happy.repo.DcChildrenRepo;
import in.happy.repo.DcIncomeRepo;
import in.happy.repo.PlanRepo;

public class EligSeriveImpl implements EligService{

	@Autowired
	private DcCaseRepo dcCaseRepo;
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private DcIncomeRepo incomeRepo;
	
	@Autowired
	private DcChildrenRepo childRepo;
	
	@Autowired
	private CitizenAppRepo citizenAppRepo;
	@Override
	public EligResponse determineEligibility(Long caseNum) {
		
		Optional<DcCaseEntity> caseEntity = dcCaseRepo.findById(caseNum);
		Integer planId = null;
		String planName = null;
		if(caseEntity.isPresent()) {
			DcCaseEntity dcCaseEntity = caseEntity.get();
		    planId = dcCaseEntity.getPlanId();
		}
		Optional<PlanEntity> planEntity = planRepo.findById(planId);
		if(planEntity.isPresent()) {
			PlanEntity plan = planEntity.get();
			planName = plan.getPlanName();
		}
		
		return executePlanConditions(caseNum,planName);
	}
	
	private EligResponse executePlanConditions(Long caseNum,String planName) {
		DcIncomeEntity income = incomeRepo.findByCaseNum(caseNum);
		Double empIncome = income.getEmpIncome();
		EligResponse response = null;
		if("SNAP".equals(planName)) {
			
			if(empIncome <= 300) {
				response.setPlanStatus("AP");
			}else {
				response.setPlanStatus("dn");
				response.setDenielReason("high income");
			}
		}else if("CCAP".equals(planName)) {
			boolean ageCondition = true;
			boolean kidsCountCondition = false;
			List<DcChildrenEntity> childs = childRepo.findByCaseNum(caseNum);
			if(!childs.isEmpty()) {
				kidsCountCondition = true;
				for(DcChildrenEntity entity : childs) {
					Integer childage = entity.getChildage();
					if(childage > 16) {
						ageCondition = false;
						break;
					}
				}
			}
			
			if(income.getEmpIncome() <= 300 && kidsCountCondition && ageCondition ) {
				response.setPlanStatus("ap");
			}else {
				response.setPlanStatus("dn");
				response.setDenielReason("Not Satisfied");
			}
		}else if("Medicaid".equals(planName)) {
			DcIncomeEntity property = incomeRepo.findByCaseNum(caseNum);
			Double propIncome = property.getPropIncome();
			if(empIncome <= 300 && propIncome == 0) {
				response.setPlanStatus("Ap");
			}else {
				response.setPlanStatus("dn");
				response.setDenielReason("income is more");
			}
				
		}else if("Medicare".equals(planName)) {
			Optional<CitizenAppEntity> citizen = citizenAppRepo.findById(caseNum);
			CitizenAppEntity entity = citizen.get();
			Integer age = entity.getAge();
			if(age >= 65) {
				response.setPlanStatus("AP");
			}else {
				response.setPlanStatus("DN");
				response.setDenielReason("Not Senior Citizen");
			}
		}
		return response;
	}

}
