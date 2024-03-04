import jakarta.persistence.EntityManager;
import org.example.Main;
import org.example.dao.EmployeeRepo;
import org.example.dao.EmployerRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(classes=Main.class)
class SpringDataRepoTest {

    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private EmployerRepo employerRepo;
    @Autowired private EmployeeRepo employeeRepo;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(employerRepo).isNotNull();
        assertThat(employeeRepo).isNotNull();
    }
}
