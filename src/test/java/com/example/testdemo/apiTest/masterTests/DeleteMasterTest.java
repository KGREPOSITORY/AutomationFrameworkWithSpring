package com.example.testdemo.apiTest.masterTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
public class DeleteMasterTest extends BaseApiMasterTest {

    @BeforeEach
    public void createMaster() {
        masterApiRequest.createMaster(validTestMaster.toRequestDto());
        validTestMaster.setId(masterService.getByFirstNameLastNamePhoneNumber(
                        validTestMaster.getFirstName(),
                        validTestMaster.getLastName(),
                        validTestMaster.getPhoneNumber())
                        .getId());
    }

    @Test
    public void deleteMaserTest() {
        masterApiRequest.deleteMasterById(validTestMaster.getId().intValue());

        assertThatThrownBy(
                () -> masterService.getById(validTestMaster.getId().intValue()))
                .isInstanceOf(EntityNotFoundException.class);


    }
}
