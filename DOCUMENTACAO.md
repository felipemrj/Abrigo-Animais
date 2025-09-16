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

## Etapa 3

A meta desta etapa foi permitir o cadastro de novos pets, garantindo que as respostas do usuário fossem lidas conforme as perguntas do formulário e armazenadas corretamente em um objeto específico, respeitando todas as regras de validação propostas.

Para atingir esse objetivo, foram criadas novas classes para modelar os dados do pet, um serviço para orquestrar o cadastro e um utilitário para validar as entradas do usuário.

### Cadastro de Pets

O cadastro é iniciado quando o usuário seleciona a opção 1 no menu principal da aplicação. Neste momento, é utilizado o método `registerPet()` da classe `RegisterPet`, responsável por todo o fluxo de perguntas, validação e preenchimento do objeto `Pet`.

A cada pergunta, uma linha do arquivo `formulario.txt` é exibida e a resposta do usuário é lida e validada. As respostas são agrupadas em objetos específicos, compondo o cadastro completo do animal.

### Principais Classes e Métodos

- **`RegisterPet`**
  - Centraliza o processo de cadastro do pet. Para cada atributo do animal, existe um método dedicado que:
    - Exibe a pergunta correspondente do formulário.
    - Chama o método de validação apropriado em `UserInputValidation`.
    - Retorna o valor já validado para compor o objeto final.

- **`Pet`**
  - Modela o animal cadastrado, agrupando os dados em atributos (nome, tipo, sexo, endereço, idade, peso, raça).
  - Utiliza outras classes auxiliares (`PetName`, `PetType`, `PetGender`, `PetAdress`) para organizar e tipar corretamente cada informação.

- **`UserInputValidation`**
  - Responsável por validar todas as respostas do usuário, seguindo as regras:
    - **Nome completo:** Obrigatório, sem caracteres especiais ou números. Se ausente, preenche com a constante `NÃO INFORMADO`.
    - **Tipo e Sexo:** Utiliza os enums `PetType` e `PetGender`, aceitando apenas valores permitidos.
    - **Endereço:** Solicita rua, número e cidade. O campo número aceita letras/números, mas se vazio, recebe `NÃO INFORMADO`.
    - **Idade:** Aceita apenas números inteiros. Valores acima de 20 lançam exceção. Para cadastrar meses são aceitos decimais de 0,01 até 0,12.
    - **Peso:** Aceita apenas números (ponto ou vírgula para decimais). Fora do intervalo permitido (menor que 0.5kg ou maior que 60kg) lança exceção.
    - **Raça:** Apenas letras, espaços, apóstrofos ou hífen. Se vazio, recebe `NÃO INFORMADO`.
  - Em caso de entrada inválida, lança a exceção customizada `InvalidInputException`, exibindo mensagem de erro ao usuário e solicitando nova entrada.

- **`InvalidInputException`**
  - Exceção criada para padronizar o tratamento de erros de entrada, facilitando a exibição de mensagens claras e o fluxo de repetição quando necessário.

  
A separação das validações em uma classe utilitária e o uso de classes para modelar cada parte dos dados garantem um código mais limpo, reutilizável e fácil de manter. O uso de enums para tipo e sexo do animal reforça a restrição dos valores possíveis, evitando erros de digitação e facilitando futuras expansões.
O preenchimento padrão com a constante `NÃO INFORMADO` garante consistência nos dados, mesmo em casos de entradas omitidas pelo usuário.


