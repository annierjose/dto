package it.annierjose.dto.model.dto;

import it.annierjose.dto.model.Team;

/**
 * The type Location dto.
 */
public class TeamDTO {

    private Team team;

    private Long totalElement;

    /**
     * Instantiates a new Team dto.
     *
     * @param teamProjection the team projection
     */
    public TeamDTO(final TeamProjection teamProjection) {
        this.team = teamProjection.getTeam();
        this.totalElement = teamProjection.getTotalElement();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return this.team.getId();
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.team.getName();
    }


    /**
     * Gets total element.
     *
     * @return the total element
     */
    public Long getTotalElement() {
        return this.totalElement;
    }
}
