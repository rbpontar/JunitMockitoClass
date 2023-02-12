package services;

import builders.FilmeBuilder;
import builders.UsuarioBuilder;
import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;
import exceptions.FilmeNaoInformadoException;
import exceptions.UsuarioNaoInformadoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

public class LocacaoServiceTest {

  @InjectMocks
  private LocacaoService service;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setup() {
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

  @Test
  public void deveAlugarFilme() throws UsuarioNaoInformadoException, FilmeNaoInformadoException {
    //cenario
    Usuario usuario = UsuarioBuilder.umUsuario().agora();
    List<Filme> filmes = List.of(FilmeBuilder.umFilme().agora());
    //acao
    Locacao locacao = service.alguar(usuario, filmes);

    //verificacao

    Assert.assertEquals(locacao, locacao);
  }

}

