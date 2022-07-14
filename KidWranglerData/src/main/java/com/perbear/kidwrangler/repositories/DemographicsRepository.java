package com.perbear.kidwrangler.repositories;

import com.perbear.kidwrangler.Model.Demographics;
import org.springframework.data.repository.CrudRepository;

public interface DemographicsRepository extends CrudRepository<Demographics, Long> {
}
