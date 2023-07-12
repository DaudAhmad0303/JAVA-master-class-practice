package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Card1 {
    private String face; // number from 2 to 9 and Jack, Queen, King, Ace
    private String suit;  // Club, Diamond, Heart, Spade.
    private int rank;  // general card number

    public Card1(String suit, String face, int rank) {
        this.suit = suit;
        this.face = face;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return face.charAt(0) + "" +
                switch (suit) {
                    case "CLUB" -> String.valueOf((char) 9827);
                    case "DIAMOND" -> String.valueOf((char) 9830);
                    case "HEART" -> String.valueOf((char) 9829);
                    case "SPADE" -> String.valueOf((char) 9824);
                    default -> 0;
                } + "(" + rank + ") ";
    }

    public static Card1 getNumericCard(String suit, int rank) {
        if (rank >= 0 && rank <= 9) {
            return new Card1(suit, String.valueOf(rank + 2), rank);
        }
        return null;
    }

    public static Card1 getFaceCard(String suit, String face) {
        return new Card1(suit, face,
                switch (face.substring(0,1)) {
                    case "J" -> 9;
                    case "Q" -> 10;
                    case "K" -> 11;
                    case "A" -> 12;
                    default -> 0;
                });
    }

    public static List<Card1> getStandardDeck() {
        List<Card1> cards1 = new ArrayList<>(52);
        ArrayList<String> faces = new ArrayList<>(List.of("JACK", "QUEEN", "KING", "ACE"));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (j < 9) {
                    switch (i) {
                        case 0 -> cards1.add(getNumericCard("CLUB", j));
                        case 1 -> cards1.add(getNumericCard("DIAMOND", j));
                        case 2 -> cards1.add(getNumericCard("HEART", j));
                        case 3 -> cards1.add(getNumericCard("SPADE", j));
                        default -> cards1.add(null);
                    }
                } else {
                    switch (j) {
                        case 9 -> cards1.add(getFaceCard("CLUB", faces.get(j-9)));
                        case 10 -> cards1.add(getFaceCard("DIAMOND", faces.get(j-9)));
                        case 11 -> cards1.add(getFaceCard("HEART", faces.get(j-9)));
                        case 12 -> cards1.add(getFaceCard("SPADE", faces.get(j-9)));
                        default -> cards1.add(null);
                    }
                }
            }
        }
        return cards1;
    }

    public static void printDeck() {
        ArrayList<Card1> cards1 = new ArrayList<>(getStandardDeck());
        for (int i = 0; i < 52; i++) {
            System.out.print(cards1.get(i));
            if ((i+1) % 13 == 0) {
                System.out.println();
            }
        }
    }
}