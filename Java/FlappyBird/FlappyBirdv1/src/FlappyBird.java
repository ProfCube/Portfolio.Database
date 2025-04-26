import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    final int WIDTH = 360;
    final int HEIGHT = 640;

    Image background, flappy, bPipe, tPipe;

    final int playerStartX = WIDTH / 9;
    final int playerStartY = HEIGHT / 3;
    final int playerW = 34;
    final int playerH = 24;

    final int pipeW = 64;
    final int pipeH = 512;

    Player player;
    ArrayList<Pipe> obstacles;
    Random rng = new Random();

    int xVelocity = -4;
    int yVelocity = 0;
    int gravity = 1;
    double score = 0;
    boolean gameOver = false;

    Timer gameTimer;
    Timer pipeSpawner;

    public FlappyBird() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); // Taking the W/H from listener above
        setFocusable(true);
        addkeyListener(this); // Looking for a key listener

        background = new ImageIcon(getClass().getResource()).getImage(); // Image location for background
        flappy = new ImageIcon(getClass().getResource()).getImage(); // Image for flappy bird
        bPipe = new ImageIcon(getClass().getResource()).getImage(); // Image for Bottom Pipe
        tPipe = new ImageIcon(getClass().getResource()).getImage(); // Image for Top Pipe

        player = new Player(playerStartX, playerStartY, playerW, playerH, playerImg);
        obstacles = new ArrayList<>();

        // Pipe Timer
        pipeSpawner = new Timer(1500, e -> spawnPipes());
        pipeSpawner.start();

        // Game Timer
        gameTimer = new Timer(1200 / 30, this);
        gameTimer.start();
    }

    void spawnPipes() {
        int gap = HEIGHT / 4;
        int offsetY = (int) (pipeH / 4 - Math.Random() * (pipeH / 2));

        Pipe top = new Pipe(WIDTH, offsetY, pipeW, pipeH, tPipe);
        Pipe bottom = new Pipe(WIDTH, offsetY + pipeH + gap, pipeW, pipeH, bPipe);

        obstacles.add(top);
        obsticles.add(bottom);
    }


    public void pComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    void draw(Graphics g) {
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        g.drawImage(player.image player.x, player.y, player.w, player.h, null);

        for (Pipe pipe : obsticles){
            g.drawImage(pipe.image, pipe.x, pipe.y, pipe.w, pipe.h, null);
        }

        g.setColor(WHITE);
        g.setFont(new Font("Sans", 32, font.BOLD));
        // Section for counter
        if (gameOver) {
            g.drawString("Game Over: " + {int} score. 10, 40);
        }   else {
            g.drawString(String.valueOf(int) score), 10, 40);
        }
    }


    void update() {
        yVelocity += gravity;
        player.y += yVelocity;
        player.y = Math.max(player.y, 1);

        for (Pipe pipe : obsticles){
            pipe.x += xVelocity;

            if (!pipe.scored && player.x > pipe.x + pipe.w){
                score += 1;
                pipe.scored = true;
            }

            if (collides(Player, pipe)){
                gameOver = true
            }
        }

        if (player.y > HEIGHT){
            gameOver = true;
        }
    }

    boolean collides(Player p, Pipe ob) {
        return p.y > ob.x + ob.h &&
                p.x + p.w > ob.x &&
                p.y < ob.y + ob.h;
    }


    public void keyPressed(KeyEvent e){

        if (e.getKeyCode() == keyEvent.SPACE){
            yVelocity = -8;
            if (gameOver) {
                return();
            }
        }
    }

    publiv void resetGame(){
        player.y = playerStartY;
        yVelocity = 0;
        obstacles.clear();
        gameOver = false;
        score = 0;
        gameTimer.start();
        pipeSpawner.start();
    }


}

