# dasafio-prova-arquivos


1 - criar a environment com o path da pasta do host 
ex: export HOME_PATH=/Users/data

na pasta principal executar

docker-compose -up


estrutura da pasta:

    - data
        - in : para arquivos de entrada 
        - out: para arquivos de saida
        - error: arquivos com erro

Formato do arquivo:
    **Só será aceito arquivos com a extensão .dat**

Os dados deverão ser separados por **;** (ponto e virgula)

Dados do vendedor
Os dados do vendedor tem o formato id 001 e a linha terá o seguinte formato.

**001;CPF;Name;Salary**

Dados do cliente

Os dados do cliente têm o formato id 002 e a linha terá o seguinte formato.

**002;CNPJ;Name;Business Area**

Dados de vendas
Os dados de vendas têm o formato id 003 . Dentro da linha de vendas, existe a lista
de itens, que é envolto por colchetes [] dentro do conchetes os itens serão separados por **-** (traço)  e a lista de itens por **,** virgula. A linha terá o seguinte formato.

**003;Sale ID;[Item ID-Item Quantity-Item Price];Salesman name**

Exemplo dos dados:
___

001;1234567891234;Pedro;50000
001;3245678865434;Paulo;40000.99
002;2345675434544345;Jose da Silva;Rural
002;2345675433444345;Eduardo Pereira;Rural
003;10;[1-10-100,2-30-2.50,3-40-3.10];Pedro
003;08;[1-34-30,2-33-1.50,3-40-0.10];Paulo

___
