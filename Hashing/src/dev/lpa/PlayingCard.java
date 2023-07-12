package dev.lpa;

public class PlayingCard {

    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
        this.internalHash = (suit.equals("Hearts")) ? 11 : 12;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

//    @Override
//    public int hashCode() {
//        return internalHash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        System.out.println("---> Checking Playing Card equality");
//        return true;
//    }

// Here're the IntelliJ's automatically generated code for equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard card = (PlayingCard) o;

        if (!suit.equals(card.suit)) return false;
        return face.equals(card.face);
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + face.hashCode();
        return result;
    }
}
