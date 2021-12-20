package examproject.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import examproject.entities.Candidate;
import examproject.repositories.PartyRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CandidateControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PartyRepo partyRepo;

    @Sql("/prepareData.sql")
    @Test
    void getAllCandidates() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/candidates")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("John Johnny1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[3]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[4]").doesNotExist());

    }

    @Sql("/prepareData.sql")
    @Test
    void createNewCandidate() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/candidate")
                .content(asJsonString(new Candidate("CREATED FROM TESTING",partyRepo.findById(1).get())))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("CREATED FROM TESTING"));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
