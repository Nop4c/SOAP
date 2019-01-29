package com.nopac.soap.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nopac.soap.dao.VoyageDao;

@Service
public class VoyageService {
	
	@Autowired
	VoyageDao voyageDao;
	
    public List<String> getListResultat() throws SQLException, ClassNotFoundException {
    	List<String> listVoyage = voyageDao.getListResultat();
        return listVoyage;
    }
    
    public Integer getPriceResultat(String country, int week) throws SQLException, ClassNotFoundException {
    	Integer prix = voyageDao.getPriceByCountryAndWeek(country, week);
        return prix;
    }
    
    public List<String> getListReservationResultat(String country) throws SQLException, ClassNotFoundException {
    	List<String> listVoyage = voyageDao.getListReservationResultat(country);
        return listVoyage;
    }
}
