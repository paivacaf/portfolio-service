package nomadit.com.portfolio.api.portfolio.unit.application.services;

import com.nomadit.api.portfolio.application.services.ProjetoService;
import com.nomadit.api.portfolio.application.usecases.ObterTodosProjetosUseCase;
import com.nomadit.api.portfolio.domain.model.Projeto;
import com.nomadit.api.portfolio.domain.repositories.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;
    @InjectMocks
    private ProjetoService projetoService;
    @Mock
    private ObterTodosProjetosUseCase obterTodosProjetosUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarProjetos() {
        // Dados de projeto fictícios para o teste
        Projeto projeto1 = Projeto.builder().nome("Projeto 1").build();
        Projeto projeto2 = Projeto.builder().nome("Projeto 2").build();
        List<Projeto> projetos = Arrays.asList(projeto1, projeto2);

        // Configurar o comportamento do repositório
        when(obterTodosProjetosUseCase.executar()).thenReturn(projetos);
        when(projetoRepository.listarProjetos()).thenReturn(projetos);

        // Chamar o método do serviço
        List<Projeto> resultado = projetoService.listarProjetos();

        // Verificar se o resultado está correto
        assertEquals(2, resultado.size());
        assertEquals(projeto1, resultado.get(0));
        assertEquals(projeto2, resultado.get(1));
    }
}
