package com.ltimindtree.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    private String testId;
    private String testSubject;
    private String description;
    private String userName;
    private int userId;
    private String assignee;
    private int totalScore;
    private List<Questions> questions;
}
