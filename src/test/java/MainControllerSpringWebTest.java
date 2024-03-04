import org.example.Main;
import org.example.model.Employee;
import org.example.model.Employer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerSpringWebTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetEmployees() {
        ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/allEmployees", Employee[].class);
        List<Employee> employees = Arrays.asList(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetEmployers() {
        ResponseEntity<Employer[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/allEmployers", Employer[].class);
        List<Employer> employers = Arrays.asList(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testAddStaff_withValidType() {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/addStaff/0", null, String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testAddStaff_withInvalidType() {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/addStaff/2", null, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
