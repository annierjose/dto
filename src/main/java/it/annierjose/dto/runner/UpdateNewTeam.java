package it.annierjose.dto.runner;

import it.annierjose.dto.model.dto.TeamUpdateDTO;
import it.annierjose.dto.model.Team;
import it.annierjose.dto.repository.TeamRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Update new team.
 */
@ComponentScan("it.gattifederico.customrepository")
public class UpdateNewTeam implements CommandLineRunner {

    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(final String... args) throws Exception {
        logger.info("Update new Team");
        TeamUpdateDTO teamUpdateDTO = new TeamUpdateDTO();
        logger.info("teamUpdatedDTO");
        teamUpdateDTO.setId(5L);
        Team team = this.teamRepository.updateTeam(teamUpdateDTO);
        logger.info("Updated team id: " + team.getId());
        logger.info("Updated team name: " + team.getName());
    }
}
