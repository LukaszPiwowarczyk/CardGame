package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

import com.mygdx.game.utils.Card;
import com.mygdx.game.utils.CardDeck;

public class MyGdxGame extends ApplicationAdapter {

    public final static float MINIMUM_VIEWPORT_SIZE = 5f;

    SpriteBatch spriteBatch;
    TextureAtlas atlas;

    OrthographicCamera cam;
    CameraInputController camController;

    CardDeck deck;

    GameScreen screen;

    @Override
    public void create() {
        //Sprites
        spriteBatch = new SpriteBatch();
        atlas = new TextureAtlas("carddeck.atlas");
        deck = new CardDeck(atlas, 2);
        screen = new GameScreen(480, 720, deck.getAllCards());

        //Camera
        cam = new OrthographicCamera();
        cam.position.set(0, 0, 50);
        cam.lookAt(0, 0, 0);
        camController = new CameraInputController(cam);

        //InputController
//      Gdx.input.setInputProcessor(camController);
        screen.show();

        layoutCardsOnTable();

    }

    void layoutCardsOnTable() {
        float margin = 0.1f;
        float start_x = -6 * (Card.CARD_WIDTH + margin);
        float x = 0, y = -1 * (Card.CARD_HEIGHT + margin);
        int i = 0;
        for (Card card : deck.getAllCards()) {
            card.setPosition(start_x + x, y);
            x += Card.CARD_WIDTH + margin;
            i++;
            if (i % 13 == 0) {
                y += Card.CARD_HEIGHT + margin;
                x = 0f;
                i = 0;
            }
        }

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        atlas.dispose();
    }

    @Override
    public void render() {
        camController.update();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(cam.combined);
        spriteBatch.begin();
        for (Card card : deck.getAllCards())
            card.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        if (width > height) {
            cam.viewportHeight = MINIMUM_VIEWPORT_SIZE;
            cam.viewportWidth = cam.viewportHeight * (float) width / (float) height;
        } else {
            cam.viewportWidth = MINIMUM_VIEWPORT_SIZE;
            cam.viewportHeight = cam.viewportWidth * (float) height / (float) width;
        }
        cam.update();
    }


}
