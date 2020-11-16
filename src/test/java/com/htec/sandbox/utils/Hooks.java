package com.htec.sandbox.utils;

import com.htec.sandbox.steps.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends BaseSteps {

    @Before("@gui")
    public void setUp() {
        setup();
    }

    @After("@gui")
    public void tearDown() {
        teardown();
    }
}
