package com.exazeit.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.exazeit.entity.Address;
import com.exazeit.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {


	List<Client> clientList;	
	
	public ClientServiceImpl() {
		//default list 
		clientList = new ArrayList();
		clientList.add(new Client("John","Alexander",4456789099L,5102249614186L,new Address("103 street","California","xyz",564327L)));
		clientList.add(new Client("James","Khan", 2345657678L, 5102249614198L ,new Address("107 street","Delhi","xyz",545897L)));
		clientList.add(new Client("Tejas","Sharma", 5432678919L,5903110126591L,new Address("Lal chaowk","Mumabi","xyz",400001L)));
		
	}
	
	@Override
	public List<Client> getClients() {
		
		return this.clientList;
	}

	@Override
	public String checkMandatoryFields(Client c) {
		String error="";
		if (c.getFirstName() == null || c.getFirstName().isBlank() || c.getFirstName().isEmpty())
		{
			error = error.concat("First name is mandatory");
		}
		if ( c.getLastName() == null  || c.getLastName().isBlank() || c.getLastName().isEmpty())
		{
			error = error.isBlank()? error.concat("Last name is mandatory"):error.concat(", Last name is mandatory") ;
		}
		
		if ( c.getIdNum() == null || c.getIdNum() == 0)
		{
			error = error.isBlank()? error.concat("ID number is mandatory"):error.concat(", ID number is mandatory") ;		
		
		}else if(( c.getIdNum() != null  || !(c.getIdNum() == 0)) && !validateIdNum(c.getIdNum().toString()))
		{
			error = error.isBlank()? error.concat("ID number is Invalid"):error.concat(", ID number is  Invalid");
		}
		//either mob should be blank but not repeated
		if(( c.getMobNum() != null || !(c.getMobNum() == 0) ) && validateMobNumRepeat(c.getMobNum()))
		{
			error = error.isBlank()? error.concat("Mobile number is duplicate"):error.concat(", Mobile number is duplicate");
		}
		
		if(error.isBlank() || error.isEmpty()) {
			error= "Client added succesfully! Please check in list or search using mobile num, ID num or Firstname";
		}
		
		
		return error;
	}

	@Override
	public String addClient(Client c) {
		String check = checkMandatoryFields(c);
		if(check.contains("succesfully")) {
		clientList.add(c);	
		}
			
		return check;//if error occurs same will returned
	}

	@Override
	public boolean validateIdNum(String id) {
		// south african id regex
		if(id.toCharArray().length != 13) 
			return false;
		if(id.matches("^[0-9]{1,13}$")) {
			return true;
		}else
			return false;
		
	}

	@Override
	public Client searchByMob(Long mob) {
	  if(mob != null) {
		
	   for(Client cl : clientList) {
	    	if(cl.getMobNum() == mob || cl.getMobNum().equals(mob)) {
	    		return cl;
	    	}
	    }
	  }
		return null;
	}

	@Override
	public Client searchByIdNum(Long idnum) {
		if(idnum != null) {
     		for(Client cl : clientList) {
	    	if(cl.getIdNum() == idnum || cl.getIdNum().equals(idnum)) {
	    		return cl;
	    	}
	     }
		}
		return null;
	}

	@Override
	public List<Client> searchByFirstName(String s) {
		//there can be multiple clients with same name so using list
		List<Client> templist= new ArrayList<Client>();
		
		for(Client cl : clientList) {
	    	if(cl.getFirstName().equalsIgnoreCase(s)) {
	    		templist.add(cl);
	    	}
	    }
		
		if(templist.size() > 0)
		    return templist;
		else
			return null;
	}

	@Override
	public boolean validateMobNumRepeat(Long mob) {
		for(Client cl : clientList) {
	    	if(cl.getMobNum() == mob) {
	    		return true;
	    	}
	     }
		return false;
	}

}
