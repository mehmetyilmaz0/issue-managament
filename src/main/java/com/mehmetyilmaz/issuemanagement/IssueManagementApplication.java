package com.mehmetyilmaz.issuemanagement;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@SpringBootApplication
public class IssueManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueManagementApplication.class, args);
	}

	@Bean // uygulamanin her yerinde kullanabilmek icin yapildi..
	// sureki nesneleri new lemek yerine modelmapper ile ayni instence uzerinde new leme yapilabilsin diye..
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	// uygulama ayaga kalkerken test datalarini otomatik yuklesin diye projects.json ile birlikte yazildi.
	// surekli data insert etmektense bu sekilde bir cozum bulundu. sonrasinda silebiliriz.
//	@Bean
//	public Jackson2RepositoryPopulatorFactoryBean populatorFactoryBean () {
//		Jackson2RepositoryPopulatorFactoryBean factoryBean = new Jackson2RepositoryPopulatorFactoryBean();
//		factoryBean.setResources(new Resource[]{ new ClassPathResource("projects.json")});
//		return factoryBean;
//	}

}
