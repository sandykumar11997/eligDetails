package in.happy.service;

import in.happy.binding.EligResponse;

public interface EligService {
	
	public EligResponse determineEligibility(Long caseNum);

}
