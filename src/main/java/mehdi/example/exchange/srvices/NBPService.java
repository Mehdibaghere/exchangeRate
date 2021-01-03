package mehdi.example.exchange.srvices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NBPService {
    private static String NBP_URL = "http://api.nbp.pl/api/exchangerates/rates/A/";
    private static String NBP_ARG = "/last?format=json";
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    /*
    http://api.nbp.pl/api/exchangerates/rates/A/GBP/today/

     */

    public NBPService() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }

    double getRateForCurrency(String currencyCode) throws JsonProcessingException {

        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity(NBP_URL + currencyCode + NBP_ARG, String.class);

        JsonNode jsonNode = objectMapper.readTree(responseEntity.getBody());

        JsonNode rate = jsonNode.path("rates").path(0).path("mid");
        return rate.asDouble();
    }

}
