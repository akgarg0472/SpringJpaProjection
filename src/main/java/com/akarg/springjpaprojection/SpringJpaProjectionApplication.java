package com.akarg.springjpaprojection;

import com.akarg.springjpaprojection.engineer.EngineerService;
import com.akarg.springjpaprojection.engineer.IEngineerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringJpaProjectionApplication implements CommandLineRunner {

    private final EngineerService engineerService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaProjectionApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        System.out.println("========================================================================");

        // this.engineerService.insert();
        // this.engineerService
        //         .getAllEngineersByType(EngineerType.SOFTWARE)
        //         .forEach(System.out::println);

        // throws converter exception
        this.engineerService
                .getEngineersHavingSalaryGreaterThan_ClassProjection(20000)
                .forEach(System.out::println);

        // works fine
        this.engineerService
                .getEngineersHavingSalaryGreaterThan_InterfaceProjection(20000)
                .forEach(this::printEngineer);

        System.out.println("========================================================================");
    }

    private void printEngineer(final IEngineerDTO engineer) {
        System.out.println("Engineer -> id=" + engineer.getId() + ", salary=" + engineer.getSalary() + ", class=" + engineer.getClass());
    }

}
