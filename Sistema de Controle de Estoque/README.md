# Sistema de Controle de Estoque<br>
Essa sistema é divido em 3 partes independentes e que influenciam uma na outra, a primeira delas é a parte Analitica que seria como o sistema funciona, a segunda seria o banco de dados e por fim a terceira o programa em Java.<br>

### Analise do Sistema<br>
O sistema é administrado por funcionarios, eles efetuam as vendas. As vendas são compostas por varios itens produtos. Esses itens produtos são instancias de produtos. Por fim os produtos são dividos em categorias e possuem descrição.<br>
De acordo com o diagrama de classe:<br>
<img
src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/Diagrama%20de%20Classe.png" alt="Diagrama de Classe"></img><br>
<br>

### Banco de Dados<br>
O modelo logico do banco de dados foi desenvolvido em cima do diagrama de classe, a principal diferença é que nele aparecem as chaves estrangeiras e as classes se transformam em tabelas.<br>
<img src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/modeloLogico.png" alt="Modelo Logico"></img><br>
<br>
O modelo fisico foi gerado em cima do modelo logico, e foram apricadas algumas alterações nele resultando em:<br>
<a href="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/modeloFisico.sql">Modelo Fisico</a><br>

Por fim algumas intâncias foram adicionadas ao banco, nas tabelas funcionario, produto, descrição do produto e categoria.<br>
<a href="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/InsertsTabelas.sql">Instâncias</a><br>

### Programação <br>
A aplicação foi desenvolvida em java, utilizando algumas ferramentas encontradas na WEB como por exemplo o JMoneyField uma alteração de um campo especifico para transformar o valor na moeda utilizada que no caso é o real.<br>
A aplicação é divido em 2 partes: front-end e back-end.<br>
## Back - end <br>
Aqui encontramos a parte com a conexão com o banco de dados, os testes realizados e as classes.<br>
## Conexão <br>
<img src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/Imagens%20do%20Sistema/Connection.png" alt="conexão"></img><br><br>
## SQL<br>
# Insert<br>
<img src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/Imagens%20do%20Sistema/save_funcionario.png" alt="Insert"></img><br><br>
# update<br>
<img src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/Imagens%20do%20Sistema/update_funcionario.png" alt="update"></img><br><br>
# select<br>
<img src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/Imagens%20do%20Sistema/select_funcionario.png" alt="select"></img><br><br>
# delete<br>
<img src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/Imagens%20do%20Sistema/delete_funcionario.png" alt="delete"></img><br><br>

## Classes <br>
<img src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/Imagens%20do%20Sistema/funcionario__classe.png" alt="classe funcionario"></img><br><br>

## Testes <br>
<img src="https://github.com/andreasjose/Curriculum/blob/master/Sistema%20de%20Controle%20de%20Estoque/SistemadeControledeEstoque/Imagens%20do%20Sistema/teste_funcionario.png" alt="teste da classe funcionario"></img><br><br>

## Front - end<br>

<hr>
<a href="https://github.com/andreasjose/Curriculum/blob/master/README.md">Retorna</a>
