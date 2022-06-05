# Projeto FireTracker - Computação Móvel 21/22

Este projeto baseia se numa aplicação para registar incêndios, consultar os incêndios, visualizar o mapa e as respetivas zonas de perigo.
Começando pela DashBoard, apresentamos algumas estatísticas sobre o distrito onde se encontra o utilizador, como se pode visualizar pelos prints.
O distrito é calculado através de geolocalização.

### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print(1).jpg" height="1100" width="650">

A lista foi implementada como pedido, tem suporte horizontal, e pode se visualizar na seguinte imagem
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print(5).jpg" height="1100" width="650">

Os detalhes da lista foram também implementados como referido no enunciado, e decidimos separar algumas informações para ser mais simples consultar os dados e ter um visual mais completo.
Acrescentamos também um ScrollView para uma melhor consulta de dados.
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print(8).jpg" height="1100" width="650">
----------------------------------------------------------------------------------------------------------------------------------------------------------------
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print(9).jpg" height="1100" width="650">

Em relação ao mapa, utilizamos o mapa do GoogleMaps, os fogos são apresentados com marcadores em que a cor muda consoante o seu estado.
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print(3).jpg" height="1100" width="650">

Quanto ao ecrã de novo registo, os 3 primeiros campos não se podem encontrar vazios,o distrito é calculado como na Dashboard, poupando tempo ao utilizador quando preeche o registo e para colocar uma foto basta escolher pela galeria do utilizador
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print(6).jpg" height="1100" width="650">

Em relação à funcionalidade extra, decidimos por bem implementar um gráfico circular e uma legenda com os fogos ativos por distrito.
Achamos uma funcionalidade bastante interessante, de boa implementação e que esteticamente enriquece a aplicação.
Utilizamos uma biblioteca que encontramos no GitHub -> implementation 'com.github.blackfizz:eazegraph:1.2.5l@aar'
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print%20(7).jpg" height="1100" width="650">

Quanto à Drawer, implementamos com um modelo semelhante ao realizado em sala de aula.
Acrescentamos um header, com o símbolo da Universidade.
Adicionamos também um botão para encerrar a aplicação.
### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print(2).jpg" height="1100" width="650">

Em relação aos filtros, é possível filtrar os fogos por distrito, por meios utilizados(se os meios foram utilizados) e por raio de incidência(não está a funcionar).

### <img src="https://github.com/ULHT-CM-2021-22/22005787-22005793/blob/main/print(4).jpg" height="1100" width="650">



Assim como foi proposto, o risco de zona atualiza o texto e a cor a cada 20 segundos, como é visivel nas imagens anteriores.

Em relação á autonomia da aplicação, quando o telemovél tem menos de 20% de bateria, o risco passa a ter a cor cinzenta e a aplicação ativa o Dark Mode. 

Link do video -> https://youtu.be/eAseKg_v5HU

Quanto à auto-avaliação, achamos que o projeto se encontra com qualidade de realização para um 14.


Projeto realizado por:
Gonçalo Nunes (a22005787) e Rafael Simões (a22005793)



