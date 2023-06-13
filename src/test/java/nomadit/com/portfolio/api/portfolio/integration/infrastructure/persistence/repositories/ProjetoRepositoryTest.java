package nomadit.com.portfolio.api.portfolio.integration.infrastructure.persistence.repositories;

import com.nomadit.api.portfolio.PortfolioServiceApplication;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.ProjetoEntity;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.RiscoEnum;
import com.nomadit.api.portfolio.infrastructure.persistence.entities.enums.StatusEnum;
import com.nomadit.api.portfolio.infrastructure.persistence.mappers.EntityMappers;
import com.nomadit.api.portfolio.infrastructure.persistence.repositories.PessoaJpaRepository;
import com.nomadit.api.portfolio.infrastructure.persistence.repositories.ProjetoJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {PortfolioServiceApplication.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjetoRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProjetoJpaRepository projetoJpaRepository;

    @Autowired
    private PessoaJpaRepository pessoaJpaRepository;

    /*@Autowired
    private EntityMappers entityMappers;*/

    @Test
    public void findByIdTest() {
        List<ProjetoEntity> entities = projetoJpaRepository.findAll();
        assertTrue(entities.isEmpty());
    }

    /*@Test
    public void criarProjeto() {


        ProjetoEntity entity = ProjetoEntity.builder()
                .nome("Projeto 1")
                .gerente(pessoaJpaRepository.findById(1L).orElseThrow())
                .risco(RiscoEnum.BAIXO_RISCO)
                .status(StatusEnum.EM_ANALISE)
                .build();


        projetoJpaRepository.save(entity);
        assertTrue(entity.getId()!=null);
    }*/
}
