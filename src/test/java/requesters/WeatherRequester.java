package requesters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
   private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
   private final String POSTFIX = ",uk&appid=b6907d289e10d714a6e88b30761fae22";

   public Response requestWeather(String city) throws JsonProcessingException {
    String url = PREFIX + city + POSTFIX;
   // dependency spring - web -- объект RestTemplate (запросы, получение обработки, результаты)
       RestTemplate restTemplate = new RestTemplate();
       String responseToParse = restTemplate.getForEntity(url, String.class).getBody();

       ObjectMapper objectMapper = new ObjectMapper();
       return objectMapper.readValue(responseToParse, Response.class);

    }
}
