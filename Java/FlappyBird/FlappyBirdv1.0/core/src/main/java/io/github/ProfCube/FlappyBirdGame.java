package io.github.ProfCube;

import com.badlogic.gdx.Game;

public class FlappyBirdGame extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }
}
