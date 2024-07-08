package com.chewingk.sql.index.service.impl;

import com.chewingk.sql.index.domain.persistent.EmployeePo;
import com.chewingk.sql.index.domain.util.DataGenerator;
import com.github.javafaker.Faker;
import com.chewingk.sql.index.controller.service.IIndexService;
import com.chewingk.sql.index.service.repository.IIndexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexService implements IIndexService {

    private final IIndexRepository repository;

    @Override
    public boolean generateTestData() {
        Faker faker = new Faker();

        List<EmployeePo> list = new ArrayList<>(10000);
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 10000; j++) {
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String phoneNumber = DataGenerator.generatePhoneNumber();
                java.sql.Date dateOfBirth = new java.sql.Date(faker.date().birthday(18, 65).getTime());
                String idNumber = DataGenerator.generateIdNumber(dateOfBirth);
                Character gender = DataGenerator.generateGender();
                String email = faker.internet().emailAddress();
                String address = faker.address().fullAddress().replace("\n", ", ");
                String zipCode = DataGenerator.generateZipCode();
                BigDecimal salary = DataGenerator.generateSalary();
                String department = faker.job().title();
                java.sql.Date joinDate = new java.sql.Date(faker.date().past(3650, java.util.concurrent.TimeUnit.DAYS).getTime());
                String status = DataGenerator.generateStatus();
                EmployeePo testEmployee = EmployeePo.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .phoneNumber(phoneNumber)
                    .idNumber(idNumber)
                    .gender(gender)
                    .email(email)
                    .dateOfBirth(dateOfBirth)
                    .address(address)
                    .zipCode(zipCode)
                    .salary(salary)
                    .department(department)
                    .joinDate(joinDate)
                    .status(status)
                    .build();
                list.add(testEmployee);
            }

            repository.batchInsert(list);
            list.clear();
            System.out.println("Batch " + i + " finished");
        }
        return true;
    }
}
