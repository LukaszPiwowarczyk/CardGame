package com.mygdx.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteTouchable extends Sprite {

    public SpriteTouchable(Texture texture) {
        super(texture);
    }

    public SpriteTouchable(Sprite sprite) {
        set(sprite);
    }

    public static float xTrans(float x) {
        return x * Gdx.graphics.getWidth() / 480;
    }

    public static float yTrans(float y) {
        return y * Gdx.graphics.getHeight() / 320;
    }

    private boolean isTouched;

    /**
     * Type: Input Listener function
     * listen if this sprite button was pressed (touched)
     *
     * @param marge : the extra touchable space out of sprite
     * @param x     : x position touched by user
     * @param y     : y position touched by user
     *              <p>
     *              return true  : Sprite touched
     *              return false : Sprite not touched
     */
    public boolean isPressing(int marge, int x, int y) {
        if ((x > getX() - xTrans(marge)) && x < getX() + getWidth() + xTrans(marge)) {
            if ((y > getY() - yTrans(marge)) && y < getY() + getHeight() + yTrans(marge)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTouched() {
        return isTouched;
    }
}
