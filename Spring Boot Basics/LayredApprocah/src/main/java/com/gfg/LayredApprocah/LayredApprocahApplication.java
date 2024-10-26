package com.gfg.LayredApprocah;

import com.gfg.LayredApprocah.Repo.EmployeeRepo;
import com.gfg.LayredApprocah.controller.EmployeeController;
import com.gfg.LayredApprocah.model.EmployeeModel;
import com.gfg.LayredApprocah.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LayredApprocahApplication {

	public static void main(String[] args) {


	ApplicationContext applicationContext =  SpringApplication.run(LayredApprocahApplication.class, args);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

		EmployeeController employeeController = applicationContext.getBean(EmployeeController.class);

		EmployeeRepo employeeRepo = applicationContext.getBean(EmployeeRepo.class);

		EmployeeModel employeeModel = applicationContext.getBean(EmployeeModel.class);

		System.out.println("EmployeeService bean is createde successfully: " + employeeService);
		System.out.println("EmployeeController bean is createde successfully: " + employeeController);
		System.out.println("EmployeeRepo bean is createde successfully: " + employeeRepo);
		System.out.println("EmployeeModel bean is createde successfully: " + employeeModel);



	}

}
