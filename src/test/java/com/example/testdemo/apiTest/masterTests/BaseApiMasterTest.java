package com.example.testdemo.apiTest.masterTests;

import com.example.testdemo.api.MasterApiRequest;
import com.example.testdemo.database.dao.MasterService;
import com.example.testdemo.database.entities.Master;
import com.example.testdemo.utils.generator.master.MasterGenerator;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseApiMasterTest {

    protected static Master validTestMaster;

    @Autowired
    protected MasterService masterService;

    @Autowired
    protected MasterGenerator masterGenerator;

    @Autowired
    protected MasterApiRequest masterApiRequest;

    @BeforeEach
    public void prepareMaster(){
        validTestMaster = masterGenerator.generateValidData();
    }

    @After
    public void deleteMaster(){
        masterService.deleteByFirsNameAndLastName(validTestMaster);
    }

}
