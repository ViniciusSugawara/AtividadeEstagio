## Objetivo das classes, dividido em pacotes
	
### Domínio: Pacote com classes POJO (Plain Old Java Objects, classes com apenas Getters e Setters)
* Participante: Representa o jogador, com informações como Nome, quantidade de apostas e uma lista das apostas do mesmo.
* Bilhete: Representa a aposta do jogador. Tem apenas um array de tamanho a ser definido, que representa os números apostados.
 
### Controllers: Pacote com classes que seguem o padrão Controller, referente ao MVC (Model View Controller).
* ParticipanteController: Cuida da manipulação de dados de Participante
* BilheteController: Cuida da manipulação de dados de Bilhete

### Jogos: Pacote com classes referente aos jogos.
#### Jogo: Classe abstrata que representa o jogo a ser executado. Possui:
* MegaSena: Jogo onde o usuário escolhe os números para jogar.
* MegaSenaSimplificada: Jogo similar a mega sena, porém com apenas um número a ser apostado.	
* Federal: Jogo onde o usuário recebe um bilhete com números pré definidos.
* FederalSimplificada: Jogo similar a federal, porém com apenas um número sorteado para o bilhete.
* SimpleJogoFactory: Classe aplicando padrão Factory para criação do jogo a partir de um método.

### Sorteadores: Pacote com classes que sorteiam valores
#### Sorteador: Interface que representa algum tipo de sorteador, dentre estes:
* SorteadorPadrao: Possui a lógica para sortear um número e retornar um array, baseado em valores como o valor máximo e a quantia de números a ser sorteado.
* SorteadorTendencioso: Possui a lógica para retornar sempre o mesmo resultado, independente do valor máximo e a quantia de números.
	
### IO: Pacote com classes que demonstram e recebem valores.
* Loteria: Classe responsável pelo controle da premiação e da interação do participante com o sorteio.
	
### Utilidades: Pacote com classes que realizam alguma tarefa de maneira mais genérica
* Verificador: Classe responsável pela verificação de condições dos métodos.
* EntradaDados: Classe estática que cuida dos métodos para receber dados.
 
