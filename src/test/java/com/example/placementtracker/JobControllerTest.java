package com.example.placementtracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.example.placementtracker.model.Job;
import org.springframework.http.ResponseEntity;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JobControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void getJobsTest() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:" + port + "/api/jobs";

        String response = restTemplate.getForObject(url, String.class);

        assertNotNull(response);

        System.out.println("GET /api/jobs response:");
        System.out.println(response);
    }
    @Test
void addJobTest() {

    RestTemplate restTemplate = new RestTemplate();

    String url = "http://localhost:" + port + "/api/jobs";

    Job job = new Job();

    job.setCompany("Infosys");
    job.setRole("Software Developer");
    job.setSource("LinkedIn");
    job.setJobLink("https://www.linkedin.com/");
    job.setStatus("APPLIED");

    ResponseEntity<Job> response =
            restTemplate.postForEntity(url, job, Job.class);

    assertNotNull(response.getBody());

    System.out.println("POST /api/jobs test passed");
    System.out.println(response.getBody());
}
}