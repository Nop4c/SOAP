package com.nopac.soap.endpoint;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nopac.soap.service.VoyageService;
import com.nopac.spring_boot_soap.voyage.ListByDestinationRequest;
import com.nopac.spring_boot_soap.voyage.ListByDestinationResponse;
import com.nopac.spring_boot_soap.voyage.ListRequest;
import com.nopac.spring_boot_soap.voyage.ListResponse;
import com.nopac.spring_boot_soap.voyage.PriceByCountryAndWeekRequest;
import com.nopac.spring_boot_soap.voyage.PriceByCountryAndWeekResponse;

@Endpoint
public class VoyageEndpoint {

    @Autowired
    private VoyageService voyageService;

/**
 * 
 * @param request
 * @return
 * Traitement des request en fonction du mode de list
 * @throws SQLException 
 * @throws ClassNotFoundException 
 */
    @PayloadRoot(namespace = "http://nopac.com/spring-boot-soap/voyage", localPart = "ListRequest")
    @ResponsePayload
    public ListResponse getListRequest(@RequestPayload ListRequest request) throws SQLException, ClassNotFoundException {
        ListResponse response = new ListResponse();
        response.setResultat(voyageService.getListResultat());
        return response;
    }
    
    @PayloadRoot(namespace = "http://nopac.com/spring-boot-soap/voyage", localPart = "PriceByCountryAndWeekRequest")
    @ResponsePayload
    public PriceByCountryAndWeekResponse getPriceByCountryAndWeekRequest(@RequestPayload PriceByCountryAndWeekRequest request) throws SQLException, ClassNotFoundException {
    	PriceByCountryAndWeekResponse response = new PriceByCountryAndWeekResponse();
        response.setResultat(voyageService.getPriceResultat(request.getCountry(), request.getWeek()));
        return response;
    }
    
    @PayloadRoot(namespace = "http://nopac.com/spring-boot-soap/voyage", localPart = "ListByDestinationRequest")
    @ResponsePayload
    public ListByDestinationResponse getListByDestinationRequest(@RequestPayload ListByDestinationRequest request) throws SQLException, ClassNotFoundException {
    	ListByDestinationResponse response = new ListByDestinationResponse();
        response.setResultat(voyageService.getListReservationResultat(request.getCountry()));
        return response;
    }
    
}
