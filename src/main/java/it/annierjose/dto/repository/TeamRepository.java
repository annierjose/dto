package it.annierjose.dto.repository;

import it.annierjose.dto.model.Team;
import it.annierjose.dto.model.dto.TeamCreateDTO;
import it.annierjose.dto.model.dto.TeamProjection;
import it.annierjose.dto.model.dto.TeamUpdateDTO;
import it.annierjose.dto.repository.customized.team.createTeam.CustomizedRepoCreate;
import it.annierjose.dto.repository.customized.team.updateTeam.CustomizedRepoUpdate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The interface Team repository.
 */
@RestController
@RequestMapping("/teams")
public interface TeamRepository extends PagingAndSortingRepository<Team, Long>, CustomizedRepoCreate, CustomizedRepoUpdate {

    /**
     * Find projection list.
     *
     * @return the list
     */
    @RestResource(exported = false)
    @Query("SELECT t as team, count(e) as totalElement FROM Team t join t.elements e group by t.name")
	List<TeamProjection> findProjection();

    @Override
    @RestResource(exported = false)
    Team save(Team entity);


    @PostMapping("/")
    Team createTeam(@RequestBody TeamCreateDTO teamCreateDTO);

    @PatchMapping("/")
    Team updateTeam(@RequestBody TeamUpdateDTO teamUpdateDTO);
}
