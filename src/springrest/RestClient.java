package springrest;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static log.Logger.stdout;


/**
 * User: gsunderam
 * Date: Jul 25, 2013
 */
public class RestClient {
  public static void main(String[] args) {
    RestTemplate rest = new RestTemplate();
    MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
    headers.add("Accept", "text/html");
    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

    //exchange method can be used to set custom headers such as above
    ResponseEntity<String> entityResponse = rest.exchange("http://localhost:8080/QuoteService/service/quotes/quoterest/{id}/{username}",
                                          HttpMethod.POST, entity, String.class, 1, "GD");
//    stdout("Response headers : " + entityResponse.getHeaders());
    stdout("JSON Response Body - exchange - : " + entityResponse.getBody());

    //This is the regular GET request method that may be used to do less fancy stuff
    String response = rest.getForObject("http://localhost:8080/QuoteService/service/quotes/quoterest/{id}/{username}", String.class, 23, "Success");

    //    getEntity.getBody();
    stdout("JSON Response using GET: " + response);
  }
}
