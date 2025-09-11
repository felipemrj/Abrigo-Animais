## Etapa 1

A meta dessa etapa era a criação de um arquivo contendo as perguntas para cadastro dos animais e, posteriormente, ler e exibir as informações do mesmo no terminal.

Para isso, foi criada a classe `FormRepository`. Esta possui dois atributos constantes: `FILE_PATH` e `FILE_NAME`, que armazenam respectivamente o caminho onde o formulário deve ser salvo e o nome do arquivo a ser criado. Optei por definir essas constantes para obter um código mais limpo e com maior escalabilidade, caso seja necessário implementar novos métodos futuramente.

Nossa classe possui dois métodos principais: `createStandardForm()` e `readStringInFile()`.

- **`createStandardForm()`**  
  É responsável pela criação do arquivo, assim como pelo preenchimento das perguntas padrão para o cadastro. Esse método cria um objeto `File` que referencia o arquivo que será criado ou manipulado.  
  Com o `FileWriter`, caso o arquivo não exista, ele será criado automaticamente. O `FileWriter` também é responsável por abrir o arquivo e permitir a gravação dos dados.  
  O `BufferedWriter` armazena os dados temporariamente em um buffer, tornando a operação de escrita mais eficiente e consumindo menos recursos do sistema.  
  Juntos, `FileWriter` e `BufferedWriter` permitem que o formulário seja gerado e preenchido com as perguntas de maneira otimizada.


- **`readStringInFile()`**  
  É responsável por ler e exibir as informações do arquivo no terminal, linha por linha. Aqui também utilizamos um objeto `File` para referenciar o arquivo, seguido de `FileReader`, que irá abrir o arquivo e permitir a leitura dos dados.  
  O `BufferedReader` utiliza um buffer para otimizar a leitura e permite ler o arquivo linha por linha. Essa combinação permite que o formulário seja lido e exibido no terminal.

Em ambos os métodos, utilizamos o recurso `try-with-resources` para abrir e fechar automaticamente nossos objetos de criação, escrita e leitura de dados, garantindo uma melhor segurança e evitando vazamentos de recursos.

## Etapa 2

Nesta etapa foi criado um menu inicial para a aplicação, garantindo que o usuário só pudesse selecionar opções válidas de navegação.

Para isso, foi criada a classe `UserInterface`, responsável pelos métodos `Menu` e `validateOption`.

- **`Menu()`**  
  É responsável por apresentar continuamente o menu principal ao usuário até que uma opção válida seja selecionada. O método exibe as opções disponíveis utilizando um laço `while`, que só termina quando o valor informado estiver entre 1 e 6. O valor inicial da opção é definido como 0, garantindo que o menu seja exibido ao menos uma vez e repetido caso a entrada seja inválida.

- **`validateOption()`**  
  É responsável por validar a escolha do usuário. O método realiza três verificações principais:
    - Se a entrada está vazia, exibindo uma mensagem de alerta caso isso ocorra.
    - Se a entrada pode ser convertida para inteiro utilizando `Integer.parseInt()`. Caso a conversão falhe, uma exceção é capturada e uma mensagem de erro é exibida.
    - Se o valor convertido está dentro do intervalo permitido (entre 1 e 6), exibindo uma mensagem específica caso seja inválido.

A entrada do usuário é lida como uma `String` e passa pelas validações antes de ser aceita como opção válida. O método retorna 0 sempre que a entrada for inválida, forçando o menu a ser exibido novamente até o usuário fornecer uma opção correta.
