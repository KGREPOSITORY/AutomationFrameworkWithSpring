package com.example.testdemo.api;

import com.example.testdemo.dto.AbstractDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public abstract class BaseApi<T extends AbstractDTO> {

    private final RestTemplate restTemplate;


    @Autowired
    public BaseApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    protected ResponseEntity<T> getRequest(String endpoint, Class<T> responseType) {
        log.info("Performing GET request for endpoint: {},\n response type: {} ",
                endpoint, responseType.getName());
        return restTemplate.getForEntity(endpoint, responseType);
    }

    protected ResponseEntity<T> postRequest(String endpoint,
                                            Object requestObject,
                                            Class<T> responseType) {
        log.info("Performing POST request for endpoint: {}," +
                        "\n with following parameter : \n" +
                        "Request: {}\n" +
                        "Response type: {}",
                endpoint, requestObject.toString(), responseType.getName());
        return restTemplate.postForEntity(endpoint, requestObject, responseType);
    }

    protected void deleteRequest(String endpoint, Map<String, String> parameters) {
        log.info("Performing DELETE request for endpoint: {}\n" +
                "with following parameters: {}", endpoint, parameters);
        MultiValueMap<String, String> params = convertMapToMultiMap(parameters);
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(endpoint)
                .queryParams(params)
                .build();
        restTemplate.delete(String.valueOf(uriComponents));
    }

    private MultiValueMap<String, String> convertMapToMultiMap(Map<String, String> map) {
        return new LinkedMultiValueMap<>(
                map.entrySet().stream().collect(
                        Collectors.toMap(Map.Entry::getKey, e -> Arrays.asList(e.getValue()))));
    }
}
