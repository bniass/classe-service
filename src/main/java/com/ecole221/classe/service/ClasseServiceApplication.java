package com.ecole221.classe.service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
HibernateJpaAutoConfiguration.class})*/
public class ClasseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClasseServiceApplication.class, args);
	}

}
