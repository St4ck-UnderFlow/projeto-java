# Documentação Do Código

## Main 🎮
- Local onde o jogo é executado
- São instanciandos as classes ```Menu.java``` e ```Game.java```
- Ao executar, usa-se a função ```menu.startMenu()```, essa função mostrará as opções:
    - 1. Começar a Aventura
    - 2. Sobre o Jogo
    - 3. Sair
- Após isso, é chamada a função ```menu.requestInputNumber()```, que retornará o input digitado pelo usuário, passando um arraylist com 3 opções para validar erros como:
    - Inserir um valor que seja diferente de 1,2 e 3
    - Inserir um string ou caracteres especiais ao invés de um número inteiro
    - Deixar o campo vazio
- Logo depois, um loop é iniciaido caso opção digitada seja inválida e é usado um swtich/case para manipular a opção desejada
- Caso seja 1: A função ```game.run()``` é executada
- Caso seja 2: A função ```menu.aboutGameMenu()``` é executada
- Caso seja 3: A aplicação é finalizada

## Map 🗺️
- Clase responsável por gerenciar tudo a respesto das cidades do jogo
- Atributos:
    - [x] Todas as cidades do jogo
- Principais métodos:
    - ```Map()```: Construtor da classe que executa as funções abaixo:
        - ```setFrontiers()```: Responsável por configurar as fronterias e o poder ao chegar em cada cidade do jogo
        - ```setMissionsToCities()```: Responsável por configurar as missões nas cidades Kalb, Defalsia e Vunese Empire.

![map-colored](./assets/map-colored.png)


## City 📌
- Classe responsável por representar cada cidade do jogo
- Atributos: 
    - [x] String name
    - [x] ArrayList frontiers
    - [x] boolean hasMission
    - [x] Merchant merchant
    - [x] int powerUp
    - [x] Mission mission
- Principais Métodos:
    - ```addFrontier()```: Responsável por adicionar um fronteira, instanciando uma classe fronteira que recebe como parâmetros, a cidade de destino e o aumento/redução de poder ao entrar nessa cidade alvo. E adiciona essa fronteira no arraylist que armazena as fronteiras dessa cidade.
    - ```blockGetMissionAgain()```: Responsável por impedir o jogador de iniciar a missão da cidade novamente. Esse bloqueio é feito quando o jogador rejeita, abandona ou completa a missão.

## Mission 🎯
- Classe responsável por representar cada missão do jogo
- Atributos:
    - [x] int travelCoinsToAccept
    - [x] int travelCoinsToComplete
    - [x] int thresholdToComplete
    - [x] String goal
    - [x] City cityTarget
- Principais Métodos: 
    - ```reward()```: Responsável por recompensar o Maxwell por finalizar a missão, recebendo a instância do personagem para atualizar as informações de moedas de tranporte e limiar de poder.
    - ```complete()```: Responsável por avisar que a missão foi concluir e executar o método ```reward()```.

## Menu 📋
- Classe responsável pela exibição dos menus principais no terminal
- Menus:
    - [x] ```startMenu()```
    - [x] ```aboutGameMenu()```
    - [x] ```defaultMenu()```
    - [x] ```travelMenu()```
    - [x] ```acceptMissionMenu()```
    - [x] ```changeMissionConfirmation()```
    - [x] ```onMissionMenu()```
    - [x] ```merchantFirstQuestion()```
    - [x] ```merchantSecondQuestion()```
    - [x] ```rewardMessage()```
    - [x] ```ariveAtNargumunMessage()```