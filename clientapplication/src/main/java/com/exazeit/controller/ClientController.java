package com.exazeit.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exazeit.entity.Client;
import com.exazeit.exceptions.FirstNameNotFound;
import com.exazeit.exceptions.IDNotFound;
import com.exazeit.exceptions.MobileNotFound;
import com.exazeit.service.ClientService;

@RestController
@RequestMapping("/client")
@ComponentScan("com.exazeit")
public class ClientController {

	@Autowired
	ClientService  service;
	
	@GetMapping("/allClients")
	public List<Client> getClients() {
		return this.service.getClients();
	}
	
	
	@GetMapping("/searchByMobileNum/{mobNum}")
	public Client  searchClientByMob(@PathVariable Long mobNum) {
		
		Client c = null;
		if (null != mobNum )		  
		   c = this.service.searchByMob(mobNum);
		
		if(c == null)
			throw new MobileNotFound("Client with mobile num Not Found");
		
		return c;
		
	}
	
	@GetMapping("/searchByFirstName/{firstName}")
	public List<Client>  searchClientByFirstName(@PathVariable String firstName) {

		List<Client> clist= new ArrayList<Client>();
		if (null != firstName && !firstName.isBlank())
		    clist = this.service.searchByFirstName(firstName);

        if(null == clist || clist.isEmpty())
			throw new FirstNameNotFound("Client with provided first name Not Found");
		
        return clist;
		
	}
	
	@GetMapping("/searchByIdNum/{idNum}")
	public Client  searchClientByIdNum(@PathVariable Long idNum) {
        
        Client c= null;
		if (null != idNum )
		     c= this.service.searchByIdNum(idNum);

		if (c == null) //data not found
			 throw new IDNotFound("Client with provided ID num Not Found");
		
		
		return c;
		
	}
	
	@PostMapping("/addClient")
	public String addClient(@RequestBody Client c) {
		
		return this.service.addClient(c);
		
	}
	
	

}
