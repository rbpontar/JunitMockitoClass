package services;

import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;
import exceptions.FilmeNaoInformadoException;
import exceptions.UsuarioNaoInformadoException;

import java.util.Date;
import java.util.List;

public class LocacaoService {

  public Locacao alguar(Usuario usuario, List<Filme> filmes) throws FilmeNaoInformadoException, UsuarioNaoInformadoException {

    if (filmes == null || filmes.isEmpty()) {
      throw new FilmeNaoInformadoException("Filme deve ser informado.");
    }

    if (usuario == null) {
      throw new UsuarioNaoInformadoException("Usuário deve ser informado.");
    }

    Date dataEntrega = new Date();
    return new Locacao(usuario, filmes, new Date(), dataEntrega, 10.0);
  }

}
