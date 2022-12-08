package com.example.testdemo.utils.generator.master;

import com.example.testdemo.database.entities.Master;
import com.example.testdemo.utils.FakerUtil;
import com.example.testdemo.utils.generator.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MasterGenerator implements Generator<Master> {

    @Autowired
    FakerUtil fakerUtil;

    @Override
    public Master generateValidData() {
        return new Master(fakerUtil.getValidName(),
                fakerUtil.getValidLastName(),
                fakerUtil.getValidNumber());
    }

    @Override
    public Master generateInvalidDta() {
        return null;
    }
}
