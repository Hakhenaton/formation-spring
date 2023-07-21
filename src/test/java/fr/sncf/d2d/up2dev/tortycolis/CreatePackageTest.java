package fr.sncf.d2d.up2dev.tortycolis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = true)
public class CreatePackageTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void create() throws Exception {
        int packages = 0;
        while (packages <= 10) {
            this.mockMvc.perform(MockMvcRequestBuilders
                            .post("/packages")
                            .content("{" +
                                    "\"email\":\"test@domain.com\"," +
                                    "\"street\":\"rue de la paix\"," +
                                    "\"city\":\"Paris\"," +
                                    "\"country\":\"France\"," +
                                    "\"postalCode\":\"75006\"," +
                                    "\"phoneNumber\":\"0688888888\"," +
                                    "\"number\":\"10\"" +
                                    "" +
                                    "}")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());
            packages++;
        }

//        TODO : créer une classe annotée @ControllerAdvice pour gérer les erreurs. Posée ici l'exception est levée après le while et fait échouer le test.
//        throw new Exception(String.format("Limit packages exceeded : %s", packages));
    }
}

