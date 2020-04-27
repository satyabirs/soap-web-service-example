package com.personal.soap.endpoint;

import com.personal.soap.loaneligibility.Acknowledgement;
import com.personal.soap.loaneligibility.CustomerRequest;
import com.personal.soap.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAMESPACE="http://www.personal.com/soap/loanEligibility";

    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanEligibility(@RequestPayload CustomerRequest request)
    {
        return service.checkLoanEligibility(request);
    }
}
