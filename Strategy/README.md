# Strategy

## O que é o Strategy?

O Strategy é um padrão de projeto comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis.
Ele permite que o comportamento de um objeto seja modificado em tempo de execução sem alterar a estrutura. Isso é feito ao delegar a
responsabilidade da implementação para diferentes classes concretas que compartilham uma interface comum.

## Problema que o Strategy Resolve

Muitas vezes, um sistema precisa suportar múltiplas variações de um mesmo comportamento. Um exemplo clássico é um algoritmo de ordenação que pode ser 
substituído dependendo da necessidade (ex: QuickSort, MergeSort, BubbleSort). Sem o Strategy, a implementação de diferentes abordagens pode resultar em 
código com vários condicionais (if-else ou switch), tornando-o difícil de manter e estender.

O padrão Strategy elimina essa complexidade ao delegar a escolha do algoritmo para classes separadas, tornando o código 
mais modular, flexível e aderente ao Princípio Aberto/Fechado (Open/Closed Principle - OCP) do SOLID, permitindo a 
adição de novos comportamentos sem modificar o código existente.