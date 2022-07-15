package com.perbear.kidwrangler.services.jpa;

import com.perbear.kidwrangler.Model.Visit;
import com.perbear.kidwrangler.repositories.VisitRepository;
import com.perbear.kidwrangler.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJPAService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().iterator().forEachRemaining(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getDoctor()==null || object.getPatient()==null){
            throw new RuntimeException("Invalid visit object");
        }
        return visitRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);

    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);

    }
}
