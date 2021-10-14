package com.axelor.library.web;

import com.axelor.inject.Beans;
import com.axelor.library.db.Librarian;
import com.axelor.library.db.repo.LibrarianRepository;
import com.axelor.meta.CallMethod;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class LibrarianController {
	
	
	public void tester(ActionRequest request, ActionResponse response) {
		Context contect = request.getContext();
		
		Librarian librarian = contect.asType(Librarian.class);
		
		if(librarian.getStatusSelect()==1) {
		
		if (librarian.getId() != null) {
			librarian = Beans.get(LibrarianRepository.class).find(librarian.getId());
		}
		response.setView("ADMIN","com.axelor.library.db.Books","grid", null);
		
		response.setView("ADMIN","com.axelor.library.db.Books","grid","self.name = 'ABCD' ");
		
		response.setView("ADMIN", "com.axelor.library.db.Books","grid", "self.student.fname = 'Hardip' ");
		}
	}
	
	@CallMethod
	public void calling(ActionRequest request, ActionResponse response) {
		System.err.println("Hello request from calling");
	}
	@CallMethod
	public void callee(String name) {
		System.err.println("Hello request for calling from "+name);
	}	
}
