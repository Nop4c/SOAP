package com.nopac.soap.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nopac.soap.service.CalculService;
import com.nopac.spring_boot_soap.calcul.GetAdditionRequest;
import com.nopac.spring_boot_soap.calcul.GetAdditionResponse;
import com.nopac.spring_boot_soap.calcul.GetDivisionRequest;
import com.nopac.spring_boot_soap.calcul.GetDivisionResponse;
import com.nopac.spring_boot_soap.calcul.GetMultiplicationRequest;
import com.nopac.spring_boot_soap.calcul.GetMultiplicationResponse;
import com.nopac.spring_boot_soap.calcul.GetSoustractionRequest;
import com.nopac.spring_boot_soap.calcul.GetSoustractionResponse;

@Endpoint
public class CalculEndpoint {

    @Autowired
    private CalculService calculService;

/**
 * 
 * @param request
 * @return
 * Traitement des request en fonction du mode de calcul
 */
    @PayloadRoot(namespace = "http://nopac.com/spring-boot-soap/calcul", localPart = "getAdditionRequest")
    @ResponsePayload
    public GetAdditionResponse getAdditionRequest(@RequestPayload GetAdditionRequest request) {
        GetAdditionResponse response = new GetAdditionResponse();
        response.setResultat(calculService.getAdditionResultat(request.getValeur1(), request.getValeur2()));
        return response;
    }
    
    @PayloadRoot(namespace = "http://nopac.com/spring-boot-soap/calcul", localPart = "getSoustractionRequest")
    @ResponsePayload
    public GetSoustractionResponse getSoustractionRequest(@RequestPayload GetSoustractionRequest request) {
    	GetSoustractionResponse response = new GetSoustractionResponse();
        response.setResultat(calculService.getSoustractionResultat(request.getValeur1(), request.getValeur2()));
        return response;
    }
    
    @PayloadRoot(namespace = "http://nopac.com/spring-boot-soap/calcul", localPart = "getMultiplicationRequest")
    @ResponsePayload
    public GetMultiplicationResponse getDivisionRequest(@RequestPayload GetMultiplicationRequest request) {
    	GetMultiplicationResponse response = new GetMultiplicationResponse();
        response.setResultat(calculService.getMultiplicationResultat(request.getValeur1(), request.getValeur2()));
        return response;
    }
  
    
    @PayloadRoot(namespace = "http://nopac.com/spring-boot-soap/calcul", localPart = "getDivisionRequest")
    @ResponsePayload
    public GetDivisionResponse getDivisionRequest(@RequestPayload GetDivisionRequest request) {
    	GetDivisionResponse response = new GetDivisionResponse();
        response.setResultat(calculService.getDivisionResultat(request.getValeur1(), request.getValeur2()));
        return response;
    }
}
