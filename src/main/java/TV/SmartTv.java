package TV;

public class SmartTv {
    public boolean ligada = false;
    public int canal = 1;
    public int volume = 10;

    // Método para ligar a TV
    public void ligar() {
        ligada = true;
    }

    // Método para desligar a TV
    public void desligar() {
        ligada = false;
    }

    // Método para mudar o canal
    public void mudarCanal(int novoCanal) {
        if (ligada) {
            canal = novoCanal;
        } else {
            System.out.println("A TV está desligada. Ligue a TV primeiro.");
        }
    }

    // Método para aumentar o volume
    public void aumentarVolume() {
        if (ligada) {
            volume++;
        } else {
            System.out.println("A TV está desligada. Ligue a TV primeiro.");
        }
    }

    // Método para diminuir o volume
    public void diminuirVolume() {
        if (ligada) {
            volume--;
        } else {
            System.out.println("A TV está desligada. Ligue a TV primeiro.");
        }
    }

    // Método opcional (não estava sendo usado)
    public void setCanal(int i) {
        mudarCanal(i);
    }
}
