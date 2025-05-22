package com.pi.airsense.repository;

import com.pi.airsense.model.DHT11Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DHT11Repository extends MongoRepository<DHT11Data, String> {
}
