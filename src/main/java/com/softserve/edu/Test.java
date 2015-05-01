package com.softserve.edu;

import com.softserve.edu.app.model.old.Address;
import com.softserve.edu.app.model.old.Client;
import com.softserve.edu.app.services.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Test.class);
        ClientService clientService = applicationContext.getBean(ClientService.class);
        clientService.save(new Client("Dmytro", "Dobrovolskyi", "-", "0987061802",
                "gwini777@gmail.com", new Address("Lviv", "Lazarenka 40/414")));
        System.out.println(clientService.findByName("Dmytro"));
        System.out.println("--------------------------------------------------");
    }
}
