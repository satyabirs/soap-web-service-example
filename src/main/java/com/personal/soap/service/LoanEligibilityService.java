package com.personal.soap.service;

import com.personal.soap.loaneligibility.Acknowledgement;
import com.personal.soap.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibilityService {

    public Acknowledgement checkLoanEligibility(CustomerRequest request)
    {
        Acknowledgement acknowledgement=new Acknowledgement();
        List<String> criteriaMismatchList=acknowledgement.getCriteriaMismatch();

        if(!(request.getAge()>30 && request.getAge()<60))
        {
            criteriaMismatchList.add("age should be between 30 and 60");
        }
        if(request.getYearlyIncome()<200000)
        {
            criteriaMismatchList.add("min annual income should be 2,00,000");
        }
        if (request.getCibilScore()<500)
        {
            criteriaMismatchList.add("CIBIL score should be 500");
        }

        if(criteriaMismatchList.size()>0)
        {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        }
        else
        {
            acknowledgement.setIsEligible(true);
            acknowledgement.setApprovedAmount(500000);
        }

        return acknowledgement;
    }
}
