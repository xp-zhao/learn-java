package org.learn.flowable.mapper.repository;

import org.learn.flowable.entity.mongo.PaperData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author zhaoxiaoping
 * @date 2024-6-29
 */
public interface PaperDataRepository extends MongoRepository<PaperData, String> {}
