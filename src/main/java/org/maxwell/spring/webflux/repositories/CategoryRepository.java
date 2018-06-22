package org.maxwell.spring.webflux.repositories;

import org.maxwell.spring.webflux.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository <Category, String>{
}
