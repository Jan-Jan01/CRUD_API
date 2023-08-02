package com.example.demo.hunter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class HunterConfig {
    @Bean
    CommandLineRunner commandLineRunner(HunterRepository repository) {
        return args -> {
            Hunter sung = new Hunter(
                    "Sung Jin Woo",
                    "jinwoo@gmail.com",
                    LocalDate.of(2000, JANUARY, 1),
                    "S rank",
                    "Shadow Monarch");

            Hunter hae = new Hunter(
                    "Cha Hae In",
                    "haein@gmail.com",
                    LocalDate.of(1999, AUGUST, 13),
                    "S rank",
                    "Bright Fragment of Light");
            Hunter chul = new Hunter(
                    "Woo Jin Chul",
                    "jinchul@gmail.com",
                    LocalDate.of(1998, SEPTEMBER, 25),
                    "A rank",
                    "Bruiser/Fighter");
            repository.saveAll(List.of(sung,hae,chul));
        };
    }
}
