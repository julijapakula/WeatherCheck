package requesters;

import model.Response;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
   private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
   private final String POSTFIX = ",uk&appid=b6907d289e10d714a6e88b30761fae22";

   public Response requestWeather(String city){
    String url = PREFIX + city + POSTFIX;
   // dependency spring - web -- объект RestTemplate (запросы, получение обработки, результаты)
       RestTemplate restTemplate = new RestTemplate();
       restTemplate.getForEntity()
    }
}
