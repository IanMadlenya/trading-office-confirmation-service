package com.trading;

import org.springframework.data.mongodb.repository.MongoRepository;

interface ConfirmationRepository  extends MongoRepository<Confirmation, String> {
}
