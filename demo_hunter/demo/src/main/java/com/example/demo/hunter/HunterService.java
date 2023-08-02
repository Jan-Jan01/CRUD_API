package com.example.demo.hunter;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HunterService {

    private final HunterRepository hunterRepository;

    @Autowired
    public HunterService(HunterRepository hunterRepository){
        this.hunterRepository = hunterRepository;
    }
    public List<Hunter> getHunter(){
        return hunterRepository.findAll();
    }

    public void addNewHunter(Hunter hunter) {
        Optional<Hunter> hunterOptional = hunterRepository.findHunterByEmail(hunter.getEmail());
        if(hunterOptional.isPresent()){
            throw new IllegalStateException("Email is taken");
        }
        hunterRepository.save(hunter);
    }

    public void deleteHunter(Long hunterId) {
        boolean exists = hunterRepository.existsById(hunterId);
        if (!exists){
            throw new IllegalStateException("Hunter with id " + hunterId + " Does not exist.");
        }
        hunterRepository.deleteById(hunterId);
    }
    @Transactional
    public void updateHunter(Long hunterId, String name, String email, String job, String rank) {
        Hunter hunter = hunterRepository.findById(hunterId)
                .orElseThrow(()-> new IllegalStateException(
                        "Hunter with id " + hunterId + " does not exist"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(hunter.getName(), name)){
            hunter.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(hunter.getEmail(), email)){
            Optional<Hunter> hunterOptional = hunterRepository
                    .findHunterByEmail(email);
            if (hunterOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            hunter.setEmail(email);
        }
        if (job != null && job.length() > 0 && !Objects.equals(hunter.getJob(), job)){
            hunter.setJob(job);
        }
        if (rank != null && rank.length() > 0 && !Objects.equals(hunter.getRank(), rank)){
            hunter.setRank(rank);
        }
    }
}
