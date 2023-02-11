package exceptions;


import lombok.AllArgsConstructor;

public class FilmeNaoInformadoException extends Exception {
  public FilmeNaoInformadoException(String message) {
    super(message);
  }
}
