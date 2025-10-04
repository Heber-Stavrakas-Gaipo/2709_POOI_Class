public class Dicionario {
  private Palavra palavras[];
  private int quantPalavra;

  public Dicionario(int quantPalavra) {
    this.quantPalavra = quantPalavra;
    palavras = new Palavra[quantPalavra];
  }

  public Palavra[] getPalavras() {
    return palavras;
  }

  public int getQuantPalavra() {
    return quantPalavra;
  }

  public void setPalavras(Palavra[] palavras) {
    this.palavras = palavras;
  }

  public void inserePalavra(Palavra palavra) {
    for (int i = 0; i < quantPalavra; i++) {
      if (this.palavras[i] == null) {
        this.palavras[i] = palavra;
        break;
      }
    }
  }

  public void excluiPalavra(int posicao) {
    if (posicao >= 0 && posicao < quantPalavra) {
      this.palavras[posicao] = null;
    } else {
      System.out.println("Posição inválida. Deve estar entre 0 e " + (quantPalavra - 1));
    }
  }

  public void imprimeDicionario() {
    for (int i = 0; i < quantPalavra; i++) {
      if (palavras[i] != null) {
        System.out.println("Termo: " + palavras[i].getTermo());
        String[] sigs = palavras[i].getSignificado();
        for(String s : sigs){
          if(s != null){
            System.out.println(" - " + s);
          }
        }
        System.out.println("----------------------");
      }
    }
  }
}
