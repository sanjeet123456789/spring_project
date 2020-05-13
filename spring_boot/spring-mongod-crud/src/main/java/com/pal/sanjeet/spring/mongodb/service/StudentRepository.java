package com.pal.sanjeet.spring.mongodb.service;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pal.sanjeet.spring.mongodb.model.Student;
import org.bson.types.ObjectId;
public interface StudentRepository extends MongoRepository<Student,Integer> {

}
