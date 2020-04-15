package com.mehmetyilmaz.issuemanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IssueManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueManagementApplication.class, args);
	}

	@Bean // uygulamanin her yerinde kullanabilmek icin yapildi..
	// sureki nesneleri new lemek yerine modelmapper ile ayni instence uzerinde new leme yapilabilsin diye..
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
