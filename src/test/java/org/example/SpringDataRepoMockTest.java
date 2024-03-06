package org.example;

import org.assertj.core.api.Assertions;
import org.example.Main;
import org.example.dao.EmployerRepo;
import org.example.model.Employer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes= Main.class)
public class SpringDataRepoMockTest {


    @Mock
    private EmployerRepo employerRepo;


    @Test
    public void testFindByName() {
        String name = "John";
        Employer employer = new Employer();
        employer.setName(name);
        Mockito.when(employerRepo.findByName(name)).thenReturn(employer);


        Employer found = employerRepo.findByName(name);


        Assertions.assertThat(found.getName()).isEqualTo(name);
    }

    @Test
    public void testFindBySurname() {
        String surname = "Doe";
        Employer employer = new Employer();
        employer.setSurName(surname);
        Mockito.when(employerRepo.findBySurName(surname)).thenReturn(employer);

        Employer found = employerRepo.findBySurName(surname);

        Assertions.assertThat(found.getSurName()).isEqualTo(surname);
    }
}