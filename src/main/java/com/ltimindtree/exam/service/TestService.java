package com.ltimindtree.exam.service;

import com.ltimindtree.exam.model.Test;
import com.ltimindtree.exam.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Test addTest(Test test){
        test.setTestId(UUID.randomUUID().toString().split("-")[0]);
        return testRepository.save(test);
    }

    public List<Test> findAllTests(){
        return testRepository.findAll();
    }

    public Test getTestByTestId(String testId){
        return testRepository.findById(testId).get();
    }

    public List<Test> getTestByTestSubject(String testSubject){
        return testRepository.findByTestSubject(testSubject);
    }

    public List<Test> getTestByUserId(int userId){
        return testRepository.getTestByUserId(userId);
    }

    public Test updateTest(Test testRequest){
        // get the existing document from db
        // populate new value from request to existing object/entity/document
        Test existingTask = testRepository.findById(testRequest.getTestId()).get();
        existingTask.setDescription(testRequest.getDescription());
        existingTask.setAssignee(testRequest.getAssignee());
        existingTask.setTestSubject(testRequest.getTestSubject());
        existingTask.setQuestions(testRequest.getQuestions());
        existingTask.setUserId(testRequest.getUserId());
        existingTask.setUserName(testRequest.getUserName());
        return testRepository.save(existingTask);
    }

    public String deleteTest(String testId){
        testRepository.deleteById(testId);
        return "Test deleted from dashboard";
    }
}
