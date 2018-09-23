package it.annierjose.dto.repository.customized.team.updateTeam;

import it.annierjose.dto.model.dto.TeamUpdateDTO;
import it.annierjose.dto.model.Team;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * The type Customized repo update.
 */
class CustomizedRepoUpdateImpl implements CustomizedRepoUpdate {

    private final EntityManager entityManager;

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    /**
     * Instantiates a new Customized repo update.
     *
     * @param entityManager the entity manager
     */
    CustomizedRepoUpdateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public <S extends TeamUpdateDTO> Team updateTeam(S entity) {
        Team team = entityManager.find(Team.class, entity.getId());
        MODEL_MAPPER.map(entity, team);
        team = entityManager.merge(team);
        return team;
    }
}
