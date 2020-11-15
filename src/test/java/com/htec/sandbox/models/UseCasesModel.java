package com.htec.sandbox.models;

import com.htec.sandbox.utils.ToJson;
import lombok.Data;
import org.jeasy.random.annotation.Exclude;

import java.util.List;

@Data
public class UseCasesModel implements ToJson {
    @Exclude
    private Integer usecase_id;
    @Exclude
    private Integer user_id;
    private String title;
    private String description;
    private String expected_result;
    private Boolean automated;
    private List<String> teststeps;
}
