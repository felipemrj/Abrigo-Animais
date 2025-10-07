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

## Etapa 4

A meta dessa etapa foi implementar o armazenamento das informações do pet cadastrado em um arquivo `.txt` personalizado, conforme regras específicas de formatação, localização e conteúdo, garantindo que os dados sejam persistidos corretamente e de forma organizada.

Para atender aos requisitos da etapa, foi criada a classe **`SaveDataRepository`**, responsável por salvar os dados do pet em arquivos `.txt`, seguindo todas as regras de negócio exigidas.

#### Principais métodos

- **`createPetFile(Pet pet)`**  
  Método responsável por receber o objeto `Pet` já preenchido e persistir suas informações em um arquivo `.txt`. O método realiza as seguintes operações:
  - Obtém a data e hora atual e formata de acordo com o padrão exigido (`yyyyMMdd'T'HHmm`).
  - Formata o nome e sobrenome do pet para maiúsculo, removendo espaços, para compor o nome do arquivo.
  - Monta o nome final do arquivo conforme o padrão:
    ```
    20231101T1234-FLORZINHADASILVA.TXT
    ```
  - Garante que o diretório `main/resources/petsCadastrados` exista, criando-o caso não exista.
  - Cria e abre o arquivo para escrita, persistindo cada resposta do cadastro em uma linha separada.
    - O campo endereço é salvo todo na mesma linha, conforme especificação.
    - Apenas as respostas são gravadas, uma por linha, na ordem do cadastro.
  - Utiliza `BufferedWriter` para garantir eficiência na escrita e fechamento automático dos recursos, evitando vazamento de memória.


- **Formato do nome do arquivo**  
  O arquivo é nomeado com o padrão: ano, mês, dia, 'T', hora, minuto, hífen, nome e sobrenome do pet em maiúsculo, sem espaços.
- **Local de armazenamento**  
  Todos os arquivos são salvos na pasta `main/resources/petsCadastrados` na raiz do projeto.
- **Conteúdo do arquivo**  
  Apenas as respostas do cadastro são armazenadas. O campo endereço é salvo em uma linha única. Nenhuma pergunta é incluída no arquivo.
- **Exemplo de arquivo gerado**
  ```
  1 - Florzinha da Silva
  2 - Gato
  3 - Femea
  4 - Rua 2, 456, Seilandia
  5 - 6 anos
  6 - 5kg
  7 - Siames
  ```

## Etapa 5

Nessa etapa, o objetivo foi permitir que o usuário busque por pets já cadastrados, utilizando um ou dois critérios de pesquisa, e exibir os resultados de forma clara e organizada no terminal.
Para isso, foi criada e aprimorada a classe `SearchPet`, responsável por todo o fluxo de busca, seleção dos critérios e apresentação dos resultados.

### Principais classes e métodos

- **`SearchPet`**
  - Centraliza toda a lógica de busca dos pets cadastrados, seguindo o padrão de organização adotado nas etapas anteriores.

- **Menu de busca**
  - O método `searchMenu()` apresenta ao usuário as opções para realizar a busca:
    - Busca simples (1 critério)
    - Busca detalhada (2 critérios)
  - Assim como nas etapas anteriores, as escolhas são validadas para evitar entradas inválidas.

- **Seleção de critérios**
  - O método `searchFilterMenu()` exibe os critérios disponíveis para pesquisa, permitindo que o usuário escolha entre nome/sobrenome, tipo, sexo, endereço, idade, peso ou raça.
  - Caso o critério escolhido seja endereço, o método `adressFilterMenu()` permite detalhar a busca entre rua, número da casa ou cidade.
  - A validação dos valores de busca fica centralizada em `searchValueValidation()`, que utiliza os métodos da classe `UserInputValidation`.
  - O método `adressValidation()` é responsável por determinar qual valor será utilizado na busca pelo endereço.

#### Busca de pets cadastrados

- **Criação da lista de arquivos**
  - O método `createPetList()` recupera todos os arquivos `.txt` presentes na pasta de pets cadastrados, filtrando apenas os arquivos válidos.

- **Busca simples**
  - O método `simplePetSearch()` realiza a busca por um único critério, percorrendo os arquivos e comparando o valor informado pelo usuário com o conteúdo do campo correspondente.
  - O método faz a busca ignorando maiúsculas e minúsculas (case-insensitive) e permite encontrar trechos do nome usando `.contains()`.

- **Busca detalhada**
  - O método `detailedPetSearch()` aplica dois critérios de busca em sequência, filtrando primeiro pelo critério principal e depois pelo segundo critério, garantindo resultados ainda mais precisos.

#### Exibição dos resultados

- **Formatação dos resultados**
  - O método `formatSearchResult()` apresenta os pets encontrados de forma organizada, numerando e separando os campos conforme o padrão definido:
    ```
    1. Nome - Tipo - Sexo - Endereço - Idade - Peso - Raça
    2. ...
    ```
  - Para exibir apenas as informações relevantes, é feita uma pequena limpeza nas linhas do arquivo, removendo prefixos desnecessários.

#### Exemplo de resultado exibido

```
1. Rex - Cachorro - Macho - Rua 1, 123 - Cidade 1 - 2 anos - 5kg - Vira-lata
2. Florzinha da Silva - Gato - Femea - Rua 2, 456 - Seilandia - 6 anos - 5kg - Siames
```

Com essa etapa, a aplicação passou a permitir que o usuário encontre os pets cadastrados de forma rápida e intuitiva, escolhendo um ou dois critérios de pesquisa, e visualizando os resultados conforme o padrão definido para o projeto.

## Etapa 6

O objetivo desta etapa foi implementar a funcionalidade de alteração dos dados de um pet cadastrado, permitindo ao usuário modificar informações de um animal já registrado.

### Principais mudanças e funcionalidades

#### Classe `ModifyPet`

A classe `main.service.ModifyPet` controla o fluxo de alteração dos dados de um pet. Ela foi desenvolvida para ser chamada após a realização de uma busca por pets, permitindo ao usuário escolher qual animal deseja modificar e quais dados serão alterados. Seus principais métodos são:

- **`modifyPet()`**  
  Orquestra o fluxo completo de alteração:
  1. Utiliza a classe `SearchPet` para gerar a lista de arquivos de pets cadastrados e busca pelos índices dos pets que atendem aos critérios definidos pelo usuário.
  2. Solicita ao usuário que selecione, pelo índice, o pet desejado para alteração.
  3. Permite que o usuário escolha qual informação modificar (nome/sobrenome, endereço, idade, peso ou raça).
  4. Solicita a nova informação via métodos de entrada e validação.
  5. Realiza a atualização do arquivo correspondente, substituindo a linha específica pelo novo valor informado.

- **`selectPet(ArrayList<Integer> foundPets)`**  
  Recebe a lista de índices dos pets encontrados e solicita ao usuário o número do animal que deseja modificar. A entrada é validada para garantir que o índice selecionado esteja dentro do intervalo permitido.

- **`selectInfo()`**  
  Exibe um menu para o usuário escolher qual campo deseja alterar (nome e sobrenome, endereço, idade, peso ou raça). 

- **`newInfo(int selectedInfo)`**  
  Direciona para o método adequado de coleta da nova informação, de acordo com o campo escolhido pelo usuário.

- **`lineToReplace(int selectedInfo)`**  
  Calcula o número da linha do arquivo que deve ser modificada, de acordo com o campo selecionado (considerando o formato dos arquivos de pet).

- **`replaceInfo(File selectedPetFile, int lineToReplace, String newInfo)`**  
  Realiza a substituição da informação no arquivo do pet:
  - Lê todas as linhas do arquivo em memória.
  - Formata a nova informação conforme necessário (ex: idade em anos/meses, peso com “kg”).
  - Substitui a linha correspondente pelo novo valor, mantendo o padrão de numeração.
  - Regrava todas as linhas no arquivo, efetivando a alteração.

- **Métodos auxiliares para entrada e validação:**
  - **`newName()`**: Solicita e valida o novo nome e sobrenome do pet.
  - **`newAdress()`**: Solicita e valida os campos do novo endereço.
  - **`newPetAge()`**: Solicita e valida a nova idade.
  - **`newPetWeight()`**: Solicita e valida o novo peso.
  - **`newPetBreed()`**: Solicita e valida a nova raça.
  - **`formatAge(String petAge)`**: Formata a idade informada para o padrão de anos/meses do sistema.

Todos os métodos de entrada utilizam funções da classe `UserInputValidation` para garantir que os dados estejam corretos e sigam as regras do sistema (ex: nome sem caracteres especiais, idade válida, etc).

#### Busca por índices em `SearchPet`

Foram adicionados métodos em `main.service.SearchPet` que retornam os índices dos pets encontrados em buscas simples e detalhadas:
- **`simplePetSearchIndexes(int searchFilter, String searchValue)`**  
  Retorna os índices dos arquivos de pets que atendem ao critério simples de busca.
- **`detailedPetSearchIndexes(int searchFilter1, String searchValue1, int searchFilter2, String searchValue2)`**  
  Permite buscar por dois critérios e retorna os índices dos pets que atendem aos critérios.

Esses métodos facilitam a seleção do pet correto para alteração, garantindo que o usuário modifique exatamente o animal desejado, mesmo em situações em que há múltiplos registros semelhantes.

---

### Considerações

Com essas alterações, o sistema passou a permitir que o usuário modifique dados de pets já cadastrados de forma segura e validada, mantendo o padrão de organização dos arquivos e a consistência das informações. O fluxo de busca, seleção e alteração está totalmente integrado, tornando o sistema flexível e robusto para gestão dos cadastros.