package it.annierjose.dto.runner;

import it.annierjose.dto.model.Team;
import it.annierjose.dto.model.dto.TeamCreateDTO;
import it.annierjose.dto.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;


/**
 * The type Insert new team.
 */
@ComponentScan("it.gattifederico.customrepository")
public class InsertNewTeam implements CommandLineRunner {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Insert new Team");
        TeamCreateDTO teamCreateDTO = new TeamCreateDTO();
        teamCreateDTO.setName("teamCreateDTO");
        Team team = this.teamRepository.createTeam(teamCreateDTO);
        System.out.println("Inserted team id: " + team.getId());
        System.out.println("Inserted team name: " + team.getName());
    }
}
