package com.ltimindtree.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
    private int quesNum;
    private String ques;
    private String correctAnswer;
    private String submittedAnswer;
}
