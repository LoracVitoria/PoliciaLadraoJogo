package projetoFinal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GUI g = new GUI();
        g.instanciar();
        g.atribuir();
    }

}



/*
Pelo menos 4 Classes sendo uma abstrata
Pelo menos uma Interface
Usar Herança e Implementação de Interface
Usar Polimorfismo em pelo menos um método
Usar associação e indicar por meio de comentário (//) onde está sendo feita e se é agregação ou composição
Criar tela(s) com JFRAME para interação


- Polimorfismo = permite que classes abstratas consigam receber comportamentos através de classes concretas

- Relacionamentos ligam as classes/objetos entre si criando relações lógicas entre estas entidades

=> Associação = Ex: Classe Pessoa e Classe Endereço , pessoa se relaciona com endereço

=> Associação (agregação):    independente (existe)

=> Associação (composição):   dependente (não existe)

 */