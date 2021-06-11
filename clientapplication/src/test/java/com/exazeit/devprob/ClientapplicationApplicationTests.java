package com.exazeit.devprob;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exazeit.entity.Address;
import com.exazeit.entity.Client;
import com.exazeit.service.ClientServiceImpl;

@SpringBootTest
class ClientapplicationApplicationTests {

	@Autowired
	ClientServiceImpl service;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void  searchClientByMob() {
		
        Long mobnumexist =0L;
		Long mobNum = 4456789099L;
		Client c = this.service.searchByMob(mobNum);
		if(c != null)
			mobnumexist = c.getMobNum();
		
		assertEquals(mobNum, mobnumexist);
	}
	
	@Test
	public void  searchClientByIdNum() {
		
        Long idexist = 0L;
		Long idNum = 5102249614186L;
		Client c = this.service.searchByIdNum(idNum);
		if(c != null)
			idexist = c.getIdNum();
		
		assertEquals(idNum, idexist);
	}
	
	@Test
	public void  searchClientByFirstName() {
		String name="James";
		String resultName ="";
		List<Client> templist= new ArrayList<Client>();
		templist = this.service.searchByFirstName(name);
		if(templist != null) {
			for(Client c : templist) {
				resultName = c.getFirstName();
				break;//found then break
			}
		}
		
		assertEquals(name, resultName);
	}
	
	
	
	@Test
	public void  addClient() {
        
		Client c =new Client("Jitu","Shastri",9900669099L,6612349614186L,new Address("53 street","Vegas","xyz",564897L));
		String s = this.service.addClient(c);
		String returnval= "Client added succesfully! Please check in list or search using mobile num, ID num or Firstname";
		assertEquals(returnval.contains("succesfully"), s.contains("succesfully"));
	}
	

	@Test
	public void  getClientList() {
        List<Client> list = new ArrayList<Client>();
        list = this.service.getClients();
		assertEquals(this.service.getClients() , list);
	}
	
	
	
	
}
