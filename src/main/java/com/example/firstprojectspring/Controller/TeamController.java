package com.example.firstprojectspring.Controller;

import com.example.firstprojectspring.Models.Student;
import com.example.firstprojectspring.Models.Team;
import com.example.firstprojectspring.Services.TeamServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

  @Autowired
  private TeamServices teamServices;

  @PostMapping("/teams")
  public Team saveTeam(@RequestBody Team team) {
    return teamServices.create(team);
  }

  @GetMapping("/teams")
  public List<Team> fetchTeamList() {
    return teamServices.fetchList();
  }

  @GetMapping("/team/{id}")
  public Team fetchTeamById(@PathVariable("id") Long id) {
    return teamServices.fetchById(id);
  }

  @PutMapping("/team/{id}")
  public Team updateTeam(@RequestBody Team team) {
    return teamServices.update(team);
  }

  @DeleteMapping("/team/{id}")
  public Boolean deleteStudentById(@PathVariable("id") Long teamId) {
    Team team = teamServices.deleteById(teamId);
    if (team != null) {
      return true;
    } else {
      return false;
    }
  }
}
