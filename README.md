Relatório do Projeto - Cadastro de Clientes (em Java)

Este projeto tem como objetivo criar uma aplicação simples para gerenciamento de clientes utilizando Java, Swing e SQLite. A proposta central é permitir o cadastro, visualização, edição e exclusão de informações, oferecendo uma interface gráfica básica e um banco de dados local para armazenamento.

1. Estrutura do Projeto
A estrutura do projeto é relativamente compacta. Os principais arquivos se concentram na pasta “src”, onde se encontra a classe essencial da aplicação: “AplicacaoClientes”. É essa classe que reúne toda a lógica da interface gráfica e do acesso ao banco de dados. Há também um arquivo “Main.java”, que foi criado vazio e serve apenas como ponto de entrada futuro, caso a aplicação deseje separar responsabilidades mais adiante. Além do código-fonte, o projeto possui:
•	Um arquivo “clientes.db”, que representa o banco de dados SQLite utilizado para armazenar as informações dos clientes.
•	Uma biblioteca externa “sqlite-jdbc”, adicionada na pasta lib, usada para permitir a comunicação entre o Java e o banco SQLite.
Toda a aplicação funciona essencialmente dentro de uma única classe Java, que concentra a interface, as operações do banco e o fluxo principal.

2. Descrição dos Métodos do CRUD
O projeto implementa as quatro operações básicas de um CRUD diretamente na classe principal (essas funcionalidades garantem o funcionamento completo do CRUD dentro da interface):
•	Create (Cadastrar): A aplicação coleta nome, telefone e cidade a partir dos campos de texto da interface. Após validar se todos os campos foram preenchidos, a informação é enviada ao banco por meio de uma instrução “INSERT”. Ao final, a tabela é atualizada visualmente e os campos são limpos.
•	Read (Carregar/Exibir): A leitura dos clientes ocorre através do método responsável por consultar todos os registros da tabela e preencher a interface. Cada linha obtida no banco é adicionada ao modelo da tabela, permitindo visualização imediata.
•	Update (Editar): A edição utiliza os dados selecionados pelo usuário na tabela. Depois de escolher o registro, o usuário altera os campos de texto e confirma a mudança. A atualização é feita no banco usando uma instrução UPDATE, e a tabela é carregada novamente para refletir as alterações.
•	Delete (Excluir): Para excluir um cliente, o usuário seleciona uma linha da tabela. A aplicação então executa um comando DELETE baseado no nome do cliente escolhido. Além disso, há uma opção adicional que remove todos os registros do banco, funcionando como uma “limpeza geral” da tabela.

3. Decisões de Design Tomadas
O design do projeto foi feito de modo simples e direto, adequado para alguém que está desenvolvendo uma aplicação inicial em Java:
•	Uso de Swing: A interface gráfica foi construída com Swing, aproveitando componentes como JFrame, JTable, JPanel, JTextField e JButton. A escolha fornece controle total sobre a interface, apesar de exigir mais código.
•	Banco de dados SQLite: O banco local foi escolhido pela praticidade. Ele não requer instalação de servidor e funciona bem para testes e aplicações pequenas.
•	Tudo em uma única classe: A decisão de centralizar a interface e o acesso ao banco em apenas uma classe facilitou a construção inicial, embora tenha reduzido a separação de responsabilidades. 
•	Tabela atualizada após cada ação: A aplicação recarrega os dados sempre que ocorre alguma modificação, garantindo que a interface fique sincronizada com o banco.
•	Identificação das operações pelo nome do cliente: Para editar ou excluir, o sistema identifica o registro pelo nome. 
