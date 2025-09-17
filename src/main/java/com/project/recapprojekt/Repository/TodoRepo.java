package com.project.recapprojekt.Repository;

import com.mongodb.client.MongoDatabase;
import com.project.recapprojekt.Model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepo extends MongoRepository<Todo, String> {

}
