package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Card {
    public final Suit suit;
    public final Pip pip;

    public final SpriteTouchable front;
    public final SpriteTouchable back;

    private boolean turned = false;

    public final static float CARD_WIDTH = 0.75f;
    public final static float CARD_HEIGHT = CARD_WIDTH * 277f / 200f;


    public Card(Suit suit, Pip pip, SpriteTouchable back, SpriteTouchable front) {
        back.setSize(CARD_WIDTH, CARD_HEIGHT);
        front.setSize(CARD_WIDTH, CARD_HEIGHT);
        this.suit = suit;
        this.pip = pip;
        this.back = back;
        this.front = front;
    }

    public boolean isPressing(int marge, int x, int y) {
        if (!turned) {
            return front.isPressing(marge, x, y);
        } else {
            return back.isPressing(marge, x, y);
        }
    }

    public boolean isTurned() {
        return turned;
    }

//    public boolean contains(float pointerX, float pointerY) {
//        if (!turned) {
//            if (front.getX() < pointerX && front.getX() + front.getWidth() > pointerX &&
//                    front.getY() < pointerY && front.getY() + front.getHeight() > pointerY) {
//                System.out.println(toString() + " front touched");
//                return true;
//            }
//        } else {
//            if (back.getX() < pointerX && back.getX() + back.getWidth() > pointerX &&
//                    back.getY() < pointerY && back.getY() + back.getHeight() > pointerY) {
//                System.out.println(toString() + " back touched");
//                return true;
//            }
//        }
//
//        return false;
//    }

    public void setPosition(float x, float y) {
        front.setPosition(x - 0.5f * front.getWidth(), y - 0.5f * front.getHeight());
        back.setPosition(x - 0.5f * back.getWidth(), y - 0.5f * back.getHeight());
    }

    public void turn() {
        turned = !turned;
    }

    public void turnUp() {
        turned = true;
    }

    public void turnDown() {
        turned = false;
    }

    public void draw(Batch batch) {
        if (turned)
            back.draw(batch);
        else
            front.draw(batch);
    }

    @Override
    public String toString() {
        return pip + " " + suit;
    }
}