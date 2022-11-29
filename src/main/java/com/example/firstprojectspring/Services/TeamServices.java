package com.example.firstprojectspring.Services;

import com.example.firstprojectspring.Models.Student;
import com.example.firstprojectspring.Models.Team;
import com.example.firstprojectspring.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServices implements IServices<Team> {
    @Autowired
    private TeamRepository teamRepository;


    @Override
    public Team create(Team object) {
        return teamRepository.save(object);
    }

    @Override
    public List<Team> fetchList() {
        return teamRepository.findAll();
    }

    @Override
    public Team fetchById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team != null) {
            return team.get();
        } else {
            return null;
        }
    }

    @Override
    public Team update(Team object) {
        Optional<Team> team = teamRepository.findById((long) object.getIdTeam());
        if (team != null) {
            teamRepository.save(object);
            return object;
        } else {
            return null;
        }
    }

    @Override
    public Team deleteById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team != null) {
            teamRepository.deleteById(id);
            return team.get();
        } else {
            return null;
        }
    }
}
