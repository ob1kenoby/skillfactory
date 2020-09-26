package com.skillfactory.module15;

//Task 15_5_8

import java.util.Objects;

public class Card {
    private String suit;
    private String face;

    public Card(String suit, String face) {
        if (suit == null || face == null) {
            throw new IllegalArgumentException();
        }
        this.suit = suit;
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return suit.equals(card.suit) &&
                face.equals(card.face);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face);
    }
}
