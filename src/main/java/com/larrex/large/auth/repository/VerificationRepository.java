package com.larrex.large.auth.repository;

import com.larrex.large.auth.entity.Verification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends MongoRepository<Verification,String> {
}
