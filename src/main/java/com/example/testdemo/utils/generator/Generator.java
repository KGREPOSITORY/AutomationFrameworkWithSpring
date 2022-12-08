package com.example.testdemo.utils.generator;

public interface Generator<T> {

    T generateValidData();

    T generateInvalidDta();
}
