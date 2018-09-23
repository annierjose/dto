package it.spring.dto.repository.customized.team.createTeam;

import it.spring.dto.model.Element;
import it.spring.dto.model.Team;
import it.spring.dto.model.dto.TeamCreateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * The type Customized repo create.
 */
class CustomizedRepoCreateImpl implements CustomizedRepoCreate {

    private final EntityManager entityManager;

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    /**
     * Instantiates a new Customized repo create.
     *
     * @param entityManager the entity manager
     */
    CustomizedRepoCreateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public <S extends TeamCreateDTO> Team createTeam(S entity) {
        Team team = new Team();
        MODEL_MAPPER.map(entity, team);
        Element e = new Element();
        e.setTeam(team);
        team.getElements().add(e);
        return entityManager.merge(team);
    }
}
