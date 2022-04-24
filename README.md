# Projeto FireTracker - Computação Móvel 21/22

Este projeto baseia se numa aplicação para registar incêndios, consultar os incêndios, visualizar o mapa e as respetivas zonas de perigo.
Começando pela DashBoard, apresentamos algumas estatísticas sobre o distrito escolhido pelo utilizador, como se pode visualizar pelos prints(como ainda não sabemos lidar com o GPS, utilizamos Lisboa como predefinição)

### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(1).jpg" height="1100" width="650">

Para a seleção do distrito, achamos uma boa opção adotarmos a utilização desta lista para a escolha(AlertDialog) sendo mais fácil para o utilizador, pois evita escrever e fica melhor visualmente, e fica mais fácil para nós(programadores), pois as validações ficam mais simples.
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(2).jpg" height="1100" width="650">

A lista foi implementada como pedido, tem suporte horizontal, e pode se visualizar na seguinte imagem
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(3).jpg" height="1100" width="650">

Os detalhes da lista foram também implementados como referido no enunciado, e decidimos separar algumas informações para ser mais simples consultar os dados e ter um visual mais completo.
Acrescentamos também um ScrollView para uma melhor consulta de dados.
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(4).jpg" height="1100" width="650">
----------------------------------------------------------------------------------------------------------------------------------------------------------------
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(9).jpg" height="1100" width="650">

Em relação ao mapa, como ainda não sabemos ter acesso ao GPS, utilizamos uma imagem do mapa de Portugal.
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(5).jpg" height="1100" width="650">

Quanto ao ecrã de novo registo, os 3 primeiros campos não se podem encontrar vazios, utilizamos o mesmo metodo neste ecrã que foi usado na DashBoard para selecionar o distrito e para colocar uma foto basta escolher pela galeria do utilizador
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(6).jpg" height="1100" width="650">

Em relação à funcionalidade extra, decidimos por bem implementar um gráfico circular e uma legenda com os fogos ativos por distrito.
Achamos uma funcionalidade bastante interessante, de boa implementação e que esteticamente enriquece a aplicação.
Utilizamos uma biblioteca que encontramos no GitHub -> implementation 'com.github.blackfizz:eazegraph:1.2.5l@aar'
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(7).jpg" height="1100" width="650">

Quanto à Drawer, implementamos com um modelo semelhante ao realizado em sala de aula.
Acrescentamos um header, com o símbolo da Universidade.
Adicionamos também um botão para encerrar a aplicação.
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(8).jpg" height="1100" width="650">

Assim como foi proposto, o risco de zona atualiza o texto e a cor a cada 20 segundos, como é visivel nas imagens anteriores.
O risco atualiza conforme se muda de região e ao fim dos tais 20 segundos.


Quanto à auto-avaliação, achamos que o projeto se encontra com qualidade de realização para um 14.


Projeto realizado por:
Gonçalo Nunes (a22005787) e Rafael Simões (a22005793)



