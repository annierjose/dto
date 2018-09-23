package it.spring.dto.model.dto;

import it.spring.dto.model.Team;
import org.springframework.data.rest.core.config.Projection;

/**
 * The interface Team projection.
 */
@Projection(name = "groupProjection", types = {Team.class})
public interface TeamProjection {

    /**
     * Gets team.
     *
     * @return the team
     */
    Team getTeam();

    /**
     * Gets total element.
     *
     * @return the total element
     */
    Long getTotalElement();
}
