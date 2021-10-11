package com.axelor.library.module;

import com.axelor.app.AxelorModule;
import com.axelor.library.service.BooksService;
import com.axelor.library.service.BooksServiceImpl;

public class MyBooksModule  extends AxelorModule {
	@Override
	protected void configure() {
		bind(BooksService.class).to(BooksServiceImpl.class);
	}
}
