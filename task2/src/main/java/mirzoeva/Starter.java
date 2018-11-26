package mirzoeva;

import mirzoeva.service.SortService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootApplication
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            SortService sortService = ctx.getBean(SortService.class);
            List<Integer> array = new Random()
                    .ints(100000, 0, 10000)
                    .boxed()
                    .collect(Collectors.toList());

            long start = System.currentTimeMillis();
            List<Integer> sortedArray = sortService.sort(array);
            long end = System.currentTimeMillis();
            System.out.println(String.format("Sorted array: %s\nTime of execution (ms): %s", sortedArray, end - start));
        };
    }
}
