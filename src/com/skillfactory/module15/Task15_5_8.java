package com.skillfactory.module15;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task15_5_8 {
    public static void main(String[] args) {
        String[] suits = {"diamond", "club", "heart", "spade"};
        String[] faces = {"6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        Set<Card> deck = new HashSet<>(48);
        for (String suit: suits) {
            for (String face: faces) {
                deck.add(new Card(suit, face));
            }
        }
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int suitIndex = random.nextInt(4);
            int faceIndex = random.nextInt(9);
            deck.add(new Card(suits[suitIndex], faces[faceIndex]));
        }
        System.out.println(deck.size());
    }
}
