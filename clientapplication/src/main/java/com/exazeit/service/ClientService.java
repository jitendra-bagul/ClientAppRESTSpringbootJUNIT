package com.exazeit.service;

import java.util.List;

import com.exazeit.entity.Client;

public interface ClientService {

	public List<Client> getClients();
	
	public String checkMandatoryFields(Client c);
	
	public String addClient(Client c);
	
	
	public boolean validateIdNum(String idnum);
	
	public boolean validateMobNumRepeat(Long mob);


	public Client searchByMob (Long mob);
	
	public Client searchByIdNum(Long idnum);
	
	public List<Client> searchByFirstName(String s);
	
}
