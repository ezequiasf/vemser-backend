package com.dbccompany.kafkahome.repository;

import com.dbccompany.kafkahome.entity.InfoCarroEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends MongoRepository<InfoCarroEntity, String> {
}
