package com.example.PincodeFinder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PincodeController {
    private static final String API_URL = "https://india-pincode-with-latitude-and-longitude.p.rapidapi.com/api/v1/pincode/%s";
    private static final String API_KEY = "39cf8a3f3bmsh721b729bb85aab8p1dbc5bjsn54fa628ecf0d";
    private static final String API_HOST = "india-pincode-with-latitude-and-longitude.p.rapidapi.com";

    @GetMapping("/pincode/{pincode}")
    public List<String> getPincodeDetails(@PathVariable String pincode) throws IOException {
        String apiUrlWithHeaders = String.format(API_URL, pincode) + "?rapidapi-key=" + API_KEY + "&rapidapi-host=" + API_HOST;
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrlWithHeaders, String.class);
        String json = response.getBody();

        Pincode[] code = objectMapper.readValue(json, Pincode[].class);
        List<String> details = new ArrayList<>();

        for (Pincode pinc : code) {
            details.add("Area : " + pinc.getArea());
            details.add("Latitude : " + pinc.getLat());
            details.add("Longitude : " + pinc.getLng());
            details.add("District : " + pinc.getDistrict());
            details.add("State : " + pinc.getState());
            details.add("Pincode : " + pinc.getPincode());
        }

        return details;
    }
}