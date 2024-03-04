import jakarta.persistence.EntityManager;
import org.example.Main;
import org.example.dao.EmployeeRepo;
import org.example.dao.EmployerRepo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(classes=Main.class)
class SpringDataRepoTests {

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
