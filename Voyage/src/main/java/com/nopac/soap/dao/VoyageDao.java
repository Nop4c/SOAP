package com.nopac.soap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class VoyageDao {


	Connection connection = null;


	public void connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");		
		connection = DriverManager.getConnection("jdbc:mysql://mysql-bdd-nopac.alwaysdata.net/bdd-nopac_voyage","bdd-nopac_root", "root");
	}

	public List<String> getListResultat() throws SQLException, ClassNotFoundException {
		connection();
		PreparedStatement prep1 = connection.prepareStatement("SELECT * FROM Voyage "); 
		ResultSet rs = prep1.executeQuery();
		List<String> voyageList =new ArrayList<String>();
		while(rs.next()) {
			voyageList.add("Ville : " + rs.getString(2) + " - Semaine : " + rs.getString(3) + " - Année : " + rs.getString(4)+ " - Prix : " + rs.getString(5) + " €");

		}
		return voyageList;
	}

	public Integer getPriceByCountryAndWeek(String country, int week) throws SQLException, ClassNotFoundException {
		connection();
		PreparedStatement prep = connection.prepareStatement("SELECT Prix FROM Voyage WHERE Destination = ? AND semaine = ? "); 
		prep.setString(1, country);
		prep.setInt(2, week);
		ResultSet rs = prep.executeQuery();
		int voyageList= 0;
		if(rs.next()) {
			voyageList = rs.getInt(1);	
		}
		return voyageList;
	}
	
	public List<String> getListReservationResultat(String country) throws SQLException, ClassNotFoundException {
		connection();
		PreparedStatement prep = connection.prepareStatement("SELECT * FROM Reservation WHERE destination = ? "); 
		prep.setString(1, country);
		ResultSet rs = prep.executeQuery();
		List<String> voyageList =new ArrayList<String>();
		while(rs.next()) {
			voyageList.add("Client : " + rs.getString(2) + " - Destination : " + rs.getString(3) + " - Semaine : " + rs.getString(4)+ " - Année : " + rs.getString(5) +" - Prix : " + rs.getString(6) + " €");
		}
		return voyageList;
	}

}
