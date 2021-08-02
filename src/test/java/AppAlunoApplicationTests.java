
import br.com.gabriel.model.entity.Aluno;
import br.com.gabriel.model.repository.AlunoRepository;
import br.com.gabriel.rest.AlunoController;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AppAlunoApplicationTests {   

    private Aluno aluno;    
    
    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoController alunoController;
    
    @BeforeEach
    void setMockOutput() {
        aluno = new Aluno();
        aluno.setId(1);
        aluno.setNome("Maria da Silva");
        
    }    
    
    @Test    
    public void findAlunoById() throws Exception {    
        when(alunoRepository.findById(1)).thenReturn(Optional.of(aluno));
        aluno = alunoController.acharPorId(1);
        
        assertThat(aluno.getId()).isEqualTo(aluno.getId());
    }   
    
    @Test
    public void salvarAluno() throws Exception {                
        when(alunoRepository.save(aluno)).thenReturn(aluno);
        
        aluno = alunoController.salvar(aluno);
        assertThat(aluno.getId()).isEqualTo(1);       
    }

}
