package com.example.testdemo.apiTest.masterTests;

import com.example.testdemo.database.entities.Master;
import com.example.testdemo.dto.response.MasterResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class AddMasterTest extends BaseApiMasterTest {

    @Test
    public void addMasterTest(){
         ResponseEntity<MasterResponseDTO> response =  masterApiRequest
                 .createMaster(validTestMaster.toRequestDto());

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK,
                "HTTP status code is another than 200");

        Master actualMaster = masterService.getByFirstNameLastNamePhoneNumber(
                response.getBody().getFirstName(),
                response.getBody().getLastName(),
                response.getBody().getPhoneNumber());

        Assertions.assertTrue(validTestMaster.equals(actualMaster),
                "Objects are not the same");

        assertThat(validTestMaster)
                .usingRecursiveComparison()
                .ignoringFields("serviceProviders", "id","services")
                .isEqualTo(actualMaster);
    }
}
