package it.spring.dto.runner;

import it.spring.dto.model.dto.TeamUpdateDTO;
import it.spring.dto.model.Team;
import it.spring.dto.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Update new team.
 */
@ComponentScan("it.gattifederico.customrepository")
public class UpdateNewTeam implements CommandLineRunner {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Update new Team");
        TeamUpdateDTO teamUpdateDTO = new TeamUpdateDTO();
        teamUpdateDTO.setName("teamUpdatedDTO");
        teamUpdateDTO.setId(5L);
        Team team = this.teamRepository.updateTeam(teamUpdateDTO);
        System.out.println("Updated team id: " + team.getId());
        System.out.println("Updated team name: " + team.getName());
    }
}
