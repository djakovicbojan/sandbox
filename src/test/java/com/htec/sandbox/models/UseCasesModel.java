package com.htec.sandbox.models;

import com.htec.sandbox.utils.ToJson;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.List;

@Data
public class UseCasesModel implements ToJson {
    String title;
    String description;
    String expected_result;
    Boolean automated;
    List<String> teststeps;
}
