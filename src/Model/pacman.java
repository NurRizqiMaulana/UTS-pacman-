package Model;

import javax.swing.*;
import java.awt.*;

public class pacman {
    private int jum_pemain;
    private int jum_hantu;
    private int jumLive_pacman;
    private int hidup, score;
    private final int Lebar_Layar=24;
    private final int Tinggi_layar=15;
    private final int tampilan_layar=Lebar_Layar*Tinggi_layar;
    private final int max_hantu=12;
    private final int speed_pacman=6;
    private Dimension d;
    private int currentSpeed = 3;
    private int[] dx, dy;
    private short[] screenData;
    private final int maxSpeed = 6;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;

    private final short levelData[] = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };

    public pacman(){
        initGame();
        checkMaze();
        initVariables();
    }
    private void initGame() {

        hidup = 3;
        score = 0;
        initLevel();
        jum_hantu = 6;
        currentSpeed = 3;
    }

    private void initLevel() {


        for (int i = 0; i < Lebar_Layar * Tinggi_layar; i++) {
            screenData[i] = levelData[i];
        }
    }
    private void checkMaze() {

        int i = 0;
        boolean finished = true;

        while (i < Lebar_Layar * Tinggi_layar && finished) {

            if ((screenData[i]) != 0) {
                finished = false;
            }

            i++;
        }

        if (finished) {

            score += 50;

            if (jum_hantu < max_hantu) {
                jum_hantu++;
            }

            if (currentSpeed < maxSpeed) {
                currentSpeed++;
            }

            initLevel();
        }
    }
    private void initVariables() {

        screenData = new short[Tinggi_layar * Tinggi_layar];
        d = new Dimension(400, 400);
        ghost_x = new int[max_hantu];
        ghost_dx = new int[max_hantu];
        ghost_y = new int[max_hantu];
        ghost_dy = new int[max_hantu];
        ghostSpeed = new int[max_hantu];

        dx = new int[4];
        dy = new int[4];

    }


}
