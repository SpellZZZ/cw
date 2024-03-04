import org.example.Main;
import org.example.dao.EmployerRepo;
import org.example.model.Employer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes= Main.class)
public class SpringDataRepoMockTest {


    @Mock
    private EmployerRepo employerRepo;


    @Test
    public void testFindByName() {
        // Given
        String name = "John";
        Employer employer = new Employer();
        employer.setName(name);
        when(employerRepo.findByName(name)).thenReturn(employer);


        Employer found = employerRepo.findByName(name);


        assertThat(found.getName()).isEqualTo(name);
    }

    @Test
    public void testFindBySurname() {
        String surname = "Doe";
        Employer employer = new Employer();
        employer.setSurName(surname);
        when(employerRepo.findBySurName(surname)).thenReturn(employer);

        Employer found = employerRepo.findBySurName(surname);

        assertThat(found.getSurName()).isEqualTo(surname);
    }
}