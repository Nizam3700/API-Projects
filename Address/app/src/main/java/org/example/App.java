/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    
    public static List<String> CoordinateToAddress(String response) throws JsonMappingException, JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();

        Address[] address = objectMapper.readValue(response, Address[].class);
        
        List<String> result = new ArrayList<>();
        for (Address a : address) {
            result.add(a.getAddress());
            result.add(a.getDistance());
            result.add(a.getSubregion());
            result.add(a.getRegion());
            result.add(a.getPostalcode());
            System.out.println("Successfully get Address...");
        }

        System.out.println("API_Address: "+ result );
        return result;
    }


    public static String API_Url(String apiKey,String lat, String lng){
        String apiUrl = "https://address-from-to-latitude-longitude.p.rapidapi.com/geolocationapi";
        String apiHost = "address-from-to-latitude-longitude.p.rapidapi.com";
        
    

        String apiUrlWithHeaders = apiUrl + "?rapidapi-key=" + apiKey + "&rapidapi-host=" + apiHost +"?lat=" + lat + "&lng=" + lng;
        System.out.println(apiUrlWithHeaders);

        return apiUrlWithHeaders;
    }
    public static void main(String[] args) throws IOException, JsonProcessingException, JsonMappingException {
        String apiKey = "8ddbe7b12emsh2d137c55d06ea67p1ade09jsn9a0d5f6ca7a4";
        String apiUrl = API_Url(apiKey, "13.198345950021174", "79.08887");

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiUrl);
        headers.set("x-rapidapi-host", "address-from-to-latitude-longitude.p.rapidapi.com");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> ResponseEntity = restTemplate.getForEntity(apiUrl, String.class);

        String response = ResponseEntity.getBody();

        try{
            CoordinateToAddress(response);
        }catch(JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
