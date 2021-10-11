package com.axelor.library.web;

import com.axelor.inject.Beans;
import com.axelor.library.db.Books;
import com.axelor.library.db.repo.BooksRepository;
import com.axelor.library.service.BooksService;
import com.axelor.meta.schema.actions.ActionView;
import com.axelor.meta.schema.actions.ActionView.ActionViewBuilder;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class BooksController {
	public void checker(ActionRequest request, ActionResponse response) {
//		For getting context value
		Context contect = request.getContext();
// 		For getting parent context 
//		Context parrentContext = contect.getParent();
//		System.err.println(parrentContext);

		// convert context into particular class
		Books books = contect.asType(Books.class);

		System.err.println(books);
		// you cant do crud operation with the context type object

		// you have to create that object with repo

		if (books.getId() != null) {
			books = Beans.get(BooksRepository.class).find(books.getId());
		}

		System.err.println(books);
		// used for calling service methods
		// Beans.get will help for get the object
		Beans.get(BooksService.class).validateEmail(books);

		/// response methods -- used for validation
//		response.setAlert("hello from alert");
//		response.setError("My error");
		response.setFlash("My Information");
		
		
//		used to update attributes (response.setAttr)
//		response.setAttr('fieldname', 'attribute', 'value');
		response.setAttr("name", "readonly", books);
		
		

//		Action view Builder
//		define --title model -- modelName add -- grid/form & name
		ActionViewBuilder actionviewbuilder = ActionView.define("LibraryWALA").model("com.axelor.library.db.Librarian").add("grid","library-grid");
		response.setView(actionviewbuilder.map());
		
		
//		action view 
//		It will create view 
//		title,model,grid/form,filter
		response.setView("LibraryWALA","com.axelor.library.db.Librarian","grid","bname = 'My name is King' ");
		
		
	}
}
