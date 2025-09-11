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