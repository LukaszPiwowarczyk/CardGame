package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.mygdx.game.utils.Card;

import java.util.List;

public class GameScreen implements Screen, InputProcessor {
    List<Card> cards;
    int windowWidth, windowHeight;

    public GameScreen(int windowWidth, int windowHeight, List<Card> cards) {
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        this.cards = cards;
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int x, int yy, int pointer, int button) {
        int y = Gdx.graphics.getHeight() - yy;

        for(Card card : cards) {
            // if sprite + 10 of px marge is touched
            if (card.isPressing(10, x, y)) {
                // sprite is touched down
                card.turn();
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int x, int yy, int pointer, int button) {
//        int y = Gdx.graphics.getHeight() - yy;
//
//        for (int i = 0; i < cards.size(); i++) {
//            if (cards.get(i).isPressing(10, x, y)) {
//                return false;
//            }
//        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

}