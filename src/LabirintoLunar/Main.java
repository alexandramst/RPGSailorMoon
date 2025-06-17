package LabirintoLunar;

import LabirintoLunar.Audio.Audio;
import LabirintoLunar.Jogo.Jogo;

import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Jogo jogo = new Jogo();
        jogo.iniciarJogo();

    }

}