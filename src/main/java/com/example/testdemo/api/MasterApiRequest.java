package com.example.testdemo.api;

import com.example.testdemo.dto.request.MasterRequestDTO;
import com.example.testdemo.dto.response.MasterResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MasterApiRequest extends BaseApi<MasterResponseDTO>{

    public MasterApiRequest(RestTemplate restTemplate) {
        super(restTemplate);
    }

    private final String ENDPOINT =  "/master";
    private final String ENDPOINT_WITH_PARAMETERS = ENDPOINT+"/params?";

    public ResponseEntity<MasterResponseDTO> createMaster(MasterRequestDTO master){
        return postRequest(ENDPOINT, master, MasterResponseDTO.class);
    }

    public void deleteMasterById(int id) {
        Map<String, String > parameters = new HashMap<>() ;
        parameters.put("id", (String.valueOf(id)));
        deleteRequest(ENDPOINT_WITH_PARAMETERS, parameters);
    }

    public void deleteMaster(Map<String, String> parameters) {
        deleteRequest(ENDPOINT_WITH_PARAMETERS, parameters);
    }
}
