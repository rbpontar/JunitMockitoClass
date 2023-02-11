package service;

import com.jogamp.common.util.ArrayHashSet;
import entidades.Filme;
import entidades.Usuario;
import exceptions.FilmeNaoInformadoException;
import exceptions.UsuarioNaoInformadoException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocacaoServiceTest {

  private LocacaoService service;

  @Rule
  public ExpectedException expectedException =  ExpectedException.none();

  @Before
  public void setup()
  {
    service = new LocacaoService();
  }

  @Test
  public void erroFilmeNaoInformado() throws UsuarioNaoInformadoException, FilmeNaoInformadoException {
    expectedException.expect(FilmeNaoInformadoException.class);
    service.alguar(new Usuario(), new ArrayList<>());
  }

  @Test
  public void erroUusarioNaoInformado() throws UsuarioNaoInformadoException, FilmeNaoInformadoException {
    expectedException.expect(UsuarioNaoInformadoException.class);
    List<Filme> filmes = List.of(new Filme(), new Filme(), new Filme());
    service.alguar(null, filmes);
  }

}

