package projetoFinal;


// Se relaciona com Fugitivo e Policial =>  Associação por agregação (existe sem fugitivo ou policial)

public abstract class Personagem implements Comportamento {
    public int x, y, passoF=20;
    public int altura=80, largura=50;

    public void andar(char dir) {
        switch (dir){
            case 'd':
                x+=passoF;
                break;

            case 'e':
                x-=passoF;
                break;

            case 'c':
                y-=passoF;
                break;

            case 'b':
                y+=passoF;
                break;

            default:
                break;
        }
    }

    public void andar(int id) {}
}
