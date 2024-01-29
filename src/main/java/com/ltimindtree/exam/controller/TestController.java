package com.ltimindtree.exam.controller;

import com.ltimindtree.exam.model.Test;
import com.ltimindtree.exam.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Test createTest(@RequestBody Test test){
        return testService.addTest(test);
    }

    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Test> getTests(){
        return testService.findAllTests();
    }

    @RequestMapping(value = "/getTest/{testId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Test getTest(@PathVariable String testId){
        return testService.getTestByTestId(testId);
    }

    @RequestMapping(value = "/testSubject/{testSubject}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Test> findTestUsingTestSubject(@PathVariable String testSubject){
        return testService.getTestByTestSubject(testSubject);
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Test> getTestByUserId(@PathVariable int userId){
        return testService.getTestByUserId(userId);
    }

    @RequestMapping(value = "/modifyTest", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Test modifyTest(@RequestBody Test test){
        return testService.updateTest(test);
    }

    @RequestMapping(value = "/deleteTest/{testId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String deleteTest(@PathVariable String testId){
        return testService.deleteTest(testId);
    }
}
