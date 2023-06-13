package nomadit.com.portfolio.api.portfolio.unit.application.usecases;

import com.nomadit.api.portfolio.application.usecases.CriarProjetoUseCase;
import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class CriarProjetoUseCaseTest {

    @Mock
    private ProjetoRepository projetoRepository;
    @InjectMocks
    private CriarProjetoUseCase criarProjetoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarProjeto() {
        // Dados de entrada do teste
        Projeto projeto = Projeto.builder().build();
        // Outros dados de entrada...

        // Chamar o caso de uso
        criarProjetoUseCase.executar(projeto);

        // Verificar se o método correto do repositório foi chamado
        verify(projetoRepository).criarProjeto(projeto);
    }
}
