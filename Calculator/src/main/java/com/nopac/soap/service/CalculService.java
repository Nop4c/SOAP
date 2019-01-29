package com.nopac.soap.service;


import org.springframework.stereotype.Service;

@Service
public class CalculService {
	
    public Integer getAdditionResultat(Integer a, Integer b) {
        return a + b;
    }
    
    public Integer getSoustractionResultat(Integer a, Integer b) {
        return a - b;
    }
    
    public Integer getMultiplicationResultat(Integer a, Integer b) {
        return a * b;
    }
    
    public Integer getDivisionResultat(Integer a, Integer b) {
        return a / b;
    }
}
