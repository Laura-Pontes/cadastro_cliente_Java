# Integrantes:  

- **Arthur Barbosa Pinto Albuquerque**
- **Kevin Anderson Ferreira da Silva**
- **Laura Angela Gomes Pontes**
- **Maria Júlia de Lima Azevedo**
- **Samuel Oliveira Santos**

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Ideia do Projeto: 

É um projeto simples de cadastro de clientes de uma empresa genérica aleatória desenvolvido em Java, usa Java JDK 17 ou superior, utilizando das bibliotecas Swing, Abstract Window Toolkit (AWT), JDBC (Java Database Connectivity), Swing Table Model e SQLite JDBC Driver, e é necessário o uso alguma IDE compatível com Java (VS Code, Eclipse, IntelliJ IDEA) para rodar o programa, utilizamos o VS Code para o desenvolvimento do mesmo, e é preciso instalar o Git para clonar o repósitorio. 
É um projeto que simula um sistema básico de uma empresa que usaria do programa para armazenar, consultar, atualizar e remover dados de clientes. O objetivo do 
projeto é exercitar conhecimento da linguagem Java, com conceitos de programação orientada a objetos (POO), manipulação de banco de dados e interfaces gráficas. 
O sistema representa o cadastro de clientes de uma empresa genérica, permitindo que o usuário registre informações como nome, CPF, telefone e endereço. Com funcionalidades de cadastrar novos clientes, listar clientes ja cadastrados, atualizar os dados dos clientes, excluir os clientes do cadastro e o armazenamento dos dados local. 
O projeto pode ser utilizado como base para sistemas de gestão simples, treinamento em Java Desktop ou estudo de CRUD (Create, Read, Update, Delete).

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Relatório do Projeto

[Relatório do Projeto - Cadastro de Clientes (em Java).docx](https://github.com/user-attachments/files/23893494/Relatorio.do.Projeto.-.Cadastro.de.Clientes.em.Java.docx)

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Diagrama UML
[Diagrama UML - Aplicação Clientes.pdf](https://github.com/user-attachments/files/23894847/Aplicacao.Clientes.pdf)

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Cadastro de Clientes – Java + SQLite 

Este é um projeto simples em Java que permite cadastrar, visualizar, editar e excluir clientes 
usando uma interface gráfica feita em Swing e um banco de dados SQLite. 

# Como Rodar o Projeto  

Siga os passos abaixo para conseguir executar o projeto na sua máquina. 

# 1. Instale o Java 
Você precisa ter o Java JDK 8 ou superior instalado. Se não tiver, instale o JDK no site da 
Oracle ou OpenJDK. 

# 2. Organize os arquivos do projeto 
A estrutura deve ficar assim: 
Projeto/ 
│── src/ 
│    
└── AplicacaoClientes.java 
│ 
│── lib/ 
│    
└── sqlite-jdbc-3.xx.jar 
● A pasta src contém o código. 
● A pasta lib deve conter o driver sqlite-jdbc. 
Se a pasta lib não existir, crie. 

# 3. Abrindo o projeto 
Você pode abrir em: 
● IntelliJ IDEA 
● Visual Studio Code 
● Qualquer IDE Java 

# 4. Rodando pela IDE IntelliJ IDEA 
1. Abra o projeto no IntelliJ. 

2. Clique na pasta lib → botão direito → Add as Library. 

3. Abra AplicacaoClientes.java. 

4. Clique no botão verde Run. 
A aplicação vai abrir imediatamente. 

# Visual Studio Code 
1. Instale a extensão Extension Pack for Java. 

2. Abra o projeto no VS Code. 

3. Abra AplicacaoClientes.java. 

4. Clique em Run no topo (ou no botão de play ao lado da função main). 

# Sobre o Banco de Dados 
Você não precisa criar nada manualmente. 
Ao rodar o programa pela primeira vez, ele vai criar automaticamente: 
● o arquivo clientes.db 
● a tabela clientes 

Então não é necessário configurar SQL. 
# 7. Como usar o programa 

1. Preencha Nome, Telefone e Cidade. 

2. Clique em Cadastrar. 

3. Clique em um cliente na tabela para selecioná-lo. 

4. Depois você pode: 
○ Editar 
○ Excluir 
○ Limpar Campos 
○ Apagar tabela inteira
