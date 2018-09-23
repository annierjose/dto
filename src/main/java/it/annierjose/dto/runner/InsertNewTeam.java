package it.annierjose.dto.runner;

import it.annierjose.dto.model.Team;
import it.annierjose.dto.model.dto.TeamCreateDTO;
import it.annierjose.dto.repository.TeamRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * The type Insert new team.
 */
@ComponentScan("it.gattifederico.customrepository")
public class InsertNewTeam implements CommandLineRunner {

    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(final String... args) throws Exception {
        logger.info("Insert new Team");
        TeamCreateDTO teamCreateDTO = new TeamCreateDTO();
        logger.info("teamCreateDTO");
        Team team = this.teamRepository.createTeam(teamCreateDTO);
        logger.info("Inserted team id: " + team.getId());
        logger.info("Inserted team name: " + team.getName());
    }
}
