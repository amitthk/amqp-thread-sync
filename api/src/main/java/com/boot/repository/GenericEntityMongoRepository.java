package com.boot.repository;

import com.boot.entity.GenericEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenericEntityMongoRepository extends MongoRepository<GenericEntity, String> {
}
