package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Demographics;
import com.perbear.kidwrangler.repositories.DemographicsRepository;
import com.perbear.kidwrangler.services.DemographicsService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class DemographicsJPAService implements DemographicsService {

    private final DemographicsRepository demographicsRepository;

    public DemographicsJPAService(DemographicsRepository demographicsRepository) {
        this.demographicsRepository = demographicsRepository;
    }

    @Override
    public Set<Demographics> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Demographics> findAll() {
        Set<Demographics> demographics = new HashSet<>();
        demographicsRepository.findAll().iterator().forEachRemaining(demographics::add);
        return demographics;
    }

    @Override
    public Demographics findById(Long id) {
        return demographicsRepository.findById(id).orElse(null);
    }

    @Override
    public Demographics save(Demographics object) {
        return demographicsRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        demographicsRepository.deleteById(id);

    }

    @Override
    public void delete(Demographics object) {
        demographicsRepository.delete(object);

    }
}
