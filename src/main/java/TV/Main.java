package TV;

public class Main {
    public static void main(String[] args) {
        SmartTv smartTv = new SmartTv();
        smartTv.ligar();
        smartTv.mudarCanal(13);
        smartTv.aumentarVolume();
        System.out.println("Canal: " + smartTv.canal);
        System.out.println("Volume: " + smartTv.volume);
        System.out.println("Ligada? " + smartTv.ligada);
    }
}
