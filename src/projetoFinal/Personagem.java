package projetoFinal;

public abstract class Personagem implements Comportamento {

    int x, y, passo=20;
    int altura=80, largura;

    @Override
    public void andar(char dir) {
        switch (dir){
            case 'd':
                x+=passo;
                break;

            case 'e':
                x-=passo;
                break;

            case 'c':
                y-=passo;
                break;

            case 'b':
                y+=passo;
                break;

            default:
                break;
        }
    }
}
