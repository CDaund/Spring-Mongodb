package com.ltimindtree.exam.repository;

import com.ltimindtree.exam.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TestRepository extends MongoRepository<Test, String> {
    List<Test> findByTestSubject(String testSubject);

    @Query("{userId : ?0 }")
    List<Test> getTestByUserId(int userId);
}
