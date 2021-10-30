package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private final Card[][] cards;
    private final List<Card> cardList;

    public CardDeck(TextureAtlas atlas, int backIndex) {
        cards = new Card[Suit.values().length][];
        cardList = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            cards[suit.index] = new Card[Pip.values().length];
            for (Pip pip : Pip.values()) {
                SpriteTouchable front = new SpriteTouchable(atlas.createSprite(suit.name, pip.value));
                SpriteTouchable back = new SpriteTouchable(atlas.createSprite("back", backIndex));
                Card card = new Card(suit, pip, back, front);
                cards[suit.index][pip.index] = card;
                cardList.add(card);
            }
        }
    }

    public Card getCard(Suit suit, Pip pip) {
        return cards[suit.index][pip.index];
    }

    public List<Card> getAllCards() {
        return cardList;
    }
}
