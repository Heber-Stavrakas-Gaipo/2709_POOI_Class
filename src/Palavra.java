public class Palavra {
  private String termo;
  private String significado[];
  private int quantSignificado;

  public Palavra(String termo, int quantSignificado) {
    this.termo = termo;
    this.quantSignificado = quantSignificado;
    this.significado = new String[quantSignificado];
  }

  public String getTermo() {
    return termo;
  }

  public String[] getSignificado() {
    return significado;
  }

  public int getQuantSignificado() {
    return quantSignificado;
  }

  public void setTermo(String termo) {
    this.termo = termo;
  }

  public void setQuantSignificado(int quantSignificado) {
    this.quantSignificado = quantSignificado;
    this.significado = new String[quantSignificado];
  }

  public void incluiSignificados(String significado) {
    for (int i = 0; i < quantSignificado; i++) {
      if (this.significado[i] == null) {
        this.significado[i] = significado;
        break;
      }
    }
  }

  public void alteraSignificado(String significado, int posicao) {
    if (posicao >= 0 && posicao < quantSignificado) {
      this.significado[posicao] = significado;
    } else {
      System.out.println("Posição inválida. Deve estar entre 0 e " + (quantSignificado - 1));
    }
  }
}
