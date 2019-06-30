package application.services;

import org.apache.commons.codec.Charsets;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService {


    public String sendRequest(String url, String body){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("charset", "utf-8");

        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        return answer;
    }

}
