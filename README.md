# Object-Oriented Programming - Class 27/09
## Programação Orientada a Objetos I (POOI)

### Professora: Cristina Maria Valadares de Lima
### Data: 27 de Setembro de 2025

---

## 📚 Objetivos da Aula

Esta aula aborda conceitos fundamentais de **Programação Orientada a Objetos** em Java através da implementação de um **Sistema de Dicionário Digital**, incluindo:

- **Encapsulamento** e modificadores de acesso
- **Composição** entre objetos
- **Arrays** como estrutura de dados
- **Métodos getters e setters** seguindo boas práticas
- **Manipulação de strings** e entrada de dados
- **Estruturas de controle** e algoritmos de busca
- **Validação de entrada** e tratamento de erros

---

## 🏗️ Estrutura do Projeto

```
src/
├── Palavra.java     # Classe modelo para representar uma palavra com significados
├── Dicionario.java  # Classe que gerencia uma coleção de palavras
└── App.java         # Interface de usuário e lógica principal da aplicação
```

---

## 🔍 Análise Detalhada das Classes

### 1. Classe `Palavra`

**Propósito**: Representa uma palavra do dicionário com múltiplos significados.

```java
public class Palavra {
    private String termo;              // Termo/palavra principal
    private String significado[];      // Array de significados
    private int quantSignificado;      // Quantidade máxima de significados
    
    // Construtor parametrizado
    public Palavra(String termo, int quantSignificado) {
        this.termo = termo;
        this.quantSignificado = quantSignificado;
        this.significado = new String[quantSignificado];
    }
    
    // Métodos de acesso e manipulação
    public void incluiSignificados(String significado) { ... }
    public void alteraSignificado(String significado, int posicao) { ... }
}
```

**Conceitos Demonstrados**:
- ✅ **Encapsulamento**: Todos os atributos são privados (`private`)
- ✅ **Composição**: Palavra "tem" múltiplos significados (array)
- ✅ **Construtor parametrizado**: Inicialização com termo e capacidade
- ✅ **Validação**: Verificação de limites em `alteraSignificado()`
- ✅ **Arrays dinâmicos**: Gerenciamento de posições livres

### 2. Classe `Dicionario`

**Propósito**: Gerencia uma coleção de palavras e suas operações.

```java
public class Dicionario {
    private Palavra palavras[];        // Array de palavras
    private int quantPalavra;         // Capacidade máxima do dicionário
    
    // Construtor
    public Dicionario(int quantPalavra) {
        this.quantPalavra = quantPalavra;
        palavras = new Palavra[quantPalavra];
    }
    
    // Operações CRUD
    public void inserePalavra(Palavra palavra) { ... }
    public void excluiPalavra(int posicao) { ... }
    public void imprimeDicionario() { ... }
}
```

**Conceitos Demonstrados**:
- ✅ **Coleção de objetos**: Array de objetos `Palavra`
- ✅ **Operações CRUD**: Create, Read, Update, Delete
- ✅ **Busca linear**: Localização de posições livres
- ✅ **Iteração segura**: Verificação de `null` antes de acessar objetos

### 3. Classe `App`

**Propósito**: Interface de usuário e controlador principal da aplicação.

```java
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Dicionario dicionario = new Dicionario(quantPalavras);
        
        // Menu interativo com switch-case
        do {
            // Exibir menu
            // Processar opção escolhida
            // Executar operação correspondente
        } while (option != 0);
    }
}
```

**Conceitos Demonstrados**:
- ✅ **Menu interativo**: Interface baseada em console
- ✅ **Scanner**: Entrada de dados do usuário
- ✅ **Estruturas de controle**: do-while, switch-case, for
- ✅ **Tratamento de entrada**: `nextInt()` e `nextLine()`

---

## 🎯 Algoritmos e Funcionalidades Implementadas

### 1. **Inserção de Palavra** (Algoritmo de Busca por Posição Livre)

```java
public void inserePalavra(Palavra palavra) {
    for (int i = 0; i < quantPalavra; i++) {
        if (this.palavras[i] == null) {    // Busca posição livre
            this.palavras[i] = palavra;     // Insere na primeira posição livre
            break;                          // Interrompe busca
        }
    }
}
```

**Complexidade**: O(n) - busca linear
**Características**:
- Inserção na primeira posição disponível
- Não permite duplicatas de posição
- Otimização com `break`

### 2. **Busca por Termo** (Algoritmo de Busca Linear)

```java
// Implementado na classe App - Caso 2
for (Palavra p : palavras) {
    if (p != null && p.getTermo().equalsIgnoreCase(termo)) {
        found = true;
        // Exibe palavra encontrada
        break;
    }
}
```

**Complexidade**: O(n) - busca linear
**Características**:
- Busca case-insensitive (`equalsIgnoreCase`)
- Verificação de `null` para segurança
- Enhanced for loop para melhor legibilidade

### 3. **Adição de Significados** (Algoritmo de Inserção Sequencial)

```java
public void incluiSignificados(String significado) {
    for (int i = 0; i < quantSignificado; i++) {
        if (this.significado[i] == null) {
            this.significado[i] = significado;
            break;  // CRÍTICO: Evita preencher todas as posições
        }
    }
}
```

**Melhorias Implementadas**:
- ✅ **Bug Fix**: Adicionado `break` para evitar duplicação
- ✅ **Otimização**: Para na primeira posição livre encontrada

### 4. **Impressão do Dicionário** (Algoritmo de Traversal)

```java
public void imprimeDicionario() {
    for (int i = 0; i < quantPalavra; i++) {
        if (palavras[i] != null) {
            System.out.println("Termo: " + palavras[i].getTermo());
            String[] sigs = palavras[i].getSignificado();
            for(String s : sigs) {
                if(s != null) {
                    System.out.println(" - " + s);
                }
            }
            System.out.println("----------------------");
        }
    }
}
```

**Melhorias Implementadas**:
- ✅ **Bug Fix**: Removido loop aninhado incorreto que causava repetição
- ✅ **Eficiência**: Acesso direto aos significados da palavra atual

---

## 🧠 Conceitos de POO Demonstrados

### 1. **Encapsulamento Robusto**
- **Implementação**: Todos os atributos são `private`
- **Acesso controlado**: Apenas através de métodos `public`
- **Validação**: Verificação de limites em `alteraSignificado()`
- **Exemplo**:
```java
public void alteraSignificado(String significado, int posicao) {
    if (posicao >= 0 && posicao < quantSignificado) {
        this.significado[posicao] = significado;
    } else {
        System.out.println("Posição inválida...");
    }
}
```

### 2. **Composição Multi-nível**
- **Nível 1**: `Dicionario` **contém** array de `Palavra`
- **Nível 2**: `Palavra` **contém** array de `String` (significados)
- **Vantagens**: 
  - Modularidade
  - Reutilização
  - Manutenibilidade

### 3. **Uso Adequado de Getters/Setters**

#### Padrão Implementado:
```java
// GETTER: Retorna referência (cuidado com mutabilidade)
public String[] getSignificado() {
    return significado;
}

// SETTER: Recria array (boa prática)
public void setQuantSignificado(int quantSignificado) {
    this.quantSignificado = quantSignificado;
    this.significado = new String[quantSignificado];  // Recria array
}
```

### 4. **Interface de Usuário Orientada a Objetos**
- Separação entre **modelo** (`Palavra`, `Dicionario`) e **controle** (`App`)
- Uso consistente dos métodos públicos das classes
- Não acessa diretamente atributos privados

---

## 🔧 Melhorias e Correções Implementadas

### 1. **Correção do Bug de Significados Duplicados**
**Problema**: Método `incluiSignificados()` preenchia todas as posições
```java
// ANTES (BUGADO)
for (int i = 0; i < quantSignificado; i++) {
    if (this.significado[i] == null) {
        this.significado[i] = significado;  // SEM break!
    }
}

// DEPOIS (CORRIGIDO)
for (int i = 0; i < quantSignificado; i++) {
    if (this.significado[i] == null) {
        this.significado[i] = significado;
        break;  // ✅ Para na primeira posição livre
    }
}
```

### 2. **Correção do Scanner nextLine()**
**Problema**: `nextLine()` pulava entrada após `nextInt()`
```java
// SOLUÇÃO: Consumir quebra de linha residual
int quantSignificados = scanner.nextInt();
scanner.nextLine(); // ✅ Consome \n residual
for (int i = 0; i < quantSignificados; i++) {
    String significado = scanner.nextLine(); // ✅ Funciona corretamente
}
```

### 3. **Correção da Impressão do Dicionário**
**Problema**: Loop aninhado imprimia significados de todas as palavras para cada palavra
```java
// ANTES (BUGADO)
for (int i = 0; i < quantPalavra; i++) {
    if (palavras[i] != null) {
        System.out.println("Termo: " + palavras[i].getTermo());
        for(Palavra p : palavras) {  // ❌ Loop incorreto
            String[] sigs = p.getSignificado();
            // ...
        }
    }
}

// DEPOIS (CORRIGIDO)
for (int i = 0; i < quantPalavra; i++) {
    if (palavras[i] != null) {
        System.out.println("Termo: " + palavras[i].getTermo());
        String[] sigs = palavras[i].getSignificado(); // ✅ Significados da palavra atual
        // ...
    }
}
```

### 4. **Uso Consistente de Getters**
**Melhoria**: Substituição de acessos diretos por métodos
```java
// ANTES
if (position >= 0 && position < palavras.length) { ... }

// DEPOIS (Melhor encapsulamento)
if (position >= 0 && position < dicionario.getQuantPalavra()) { ... }
```

---

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- IDE (VS Code, IntelliJ, Eclipse) ou terminal

### Execução
1. **Compilar**:
   ```bash
   cd src
   javac *.java
   ```

2. **Executar**:
   ```bash
   java App
   ```

3. **Usar o sistema**:
   - Escolha o tamanho do dicionário
   - Use o menu para inserir palavras e significados
   - Teste busca, alteração e exclusão
   - Visualize o dicionário completo

---

## 📋 Funcionalidades do Sistema

### 🔤 **Menu Principal**
1. **Inserir palavra** - Adiciona nova palavra com múltiplos significados
2. **Pesquisar palavra** - Busca por termo específico
3. **Imprimir dicionário** - Exibe todas as palavras cadastradas
4. **Alterar significado** - Modifica significado existente
5. **Excluir palavra** - Remove palavra do dicionário
0. **Sair** - Encerra aplicação

### ⚡ **Algoritmos de Busca e Manipulação**
- **Busca linear**: O(n) para localizar palavras
- **Inserção otimizada**: Para na primeira posição livre
- **Remoção segura**: Validação de limites
- **Iteração protegida**: Verificação de `null`

---

## 🧪 Exercícios Propostos

### **Básico**
1. Adicione um método `toString()` na classe `Palavra`
2. Implemente busca que retorna todas as palavras que começam com uma letra
3. Crie validação para não permitir termos vazios ou `null`

### **Intermediário**
4. Implemente ordenação alfabética das palavras no dicionário
5. Adicione método para contar quantas palavras estão cadastradas
6. Crie funcionalidade de busca por significado (busca reversa)

### **Avançado**
7. Implemente persistência de dados (salvar/carregar arquivo)
8. Adicione suporte a sinônimos e antônimos
9. Crie um sistema de categorias para as palavras
10. Implemente estrutura de dados mais eficiente (HashMap)

---

## 🔍 Conceitos de Algoritmos Abordados

### **Estruturas de Dados**
- **Arrays estáticos**: Tamanho fixo definido na criação
- **Gerenciamento de posições**: Controle de espaços livres/ocupados
- **Referências de objetos**: Diferença entre objeto e referência `null`

### **Algoritmos de Busca**
- **Busca linear**: Varredura sequencial até encontrar elemento
- **Busca com critério**: Comparação case-insensitive
- **Busca por posição**: Localização de índices específicos

### **Padrões de Iteração**
- **Enhanced for loop**: `for(Tipo elemento : colecao)`
- **Iteração indexada**: `for(int i = 0; i < tamanho; i++)`
- **Iteração condicional**: Verificação de `null` antes do acesso

---

## 📚 Referências e Conceitos Relacionados

### **Design Patterns Aplicados**
- **Model-View-Controller (MVC)**: Separação entre dados, apresentação e controle
- **Composite Pattern**: Objetos compostos (Dicionário → Palavras → Significados)

### **Princípios SOLID**
- **Single Responsibility**: Cada classe tem uma responsabilidade específica
- **Encapsulation**: Dados privados com interface pública controlada

### **Clean Code**
- **Nomenclatura descritiva**: `inserePalavra()`, `excluiPalavra()`
- **Métodos pequenos**: Cada método faz apenas uma coisa
- **Tratamento de edge cases**: Validação de limites e `null`

---

## 🎓 Conclusão Pedagógica

Este projeto demonstra de forma prática conceitos fundamentais de POO:
- **Encapsulamento** protege dados e garante consistência
- **Composição** permite modelar relacionamentos reais
- **Boas práticas** de programação resultam em código mais robusto
- **Debugging** e **correção de bugs** são habilidades essenciais

O sistema de dicionário serve como base sólida para entender como objetos interagem em aplicações reais, preparando os estudantes para projetos mais complexos.

---

*Este projeto foi desenvolvido para fins educacionais na disciplina de Programação Orientada a Objetos I do Curso de Engenharia da Computação.*
