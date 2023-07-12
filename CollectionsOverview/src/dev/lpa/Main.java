package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        Collection<String> list = new HashSet<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

//        Collection does not have a sort method
//        list.sort();


//        --------------------------------------------------------------------------
        Card1.printDeck();

//        --------------------------------------------------------------------------
        Card.printDeck(new ArrayList<>(Card.getStandardDeck()));

//        --------------------------------------------------------------------------
        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard((Card.Suit.HEART), 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("Cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings Of Clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

//        Collections.copy actually replaces the objects in cards, if
//        anyone's present there
        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffle Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck of Cards:", 4);

//        Sorting in collection with Comparator and without comparator
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

//        Collections.indexOfSubList is used to check whether a sub list is part
//        of a full list in contiguous location
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("Sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        Collections.shuffle(deck);
        subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("Sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

//        Collections.disjoint returns true if both of the lists have
//        no common elements
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("Disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("Disjoint2 = " + disjoint2);

//        --------------------------------------------------------------------------

        deck.sort(sortingAlgorithm);
//        For Collections.binarySearch method our list must be sorted prior.
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = " + foundIndex);
        System.out.println("foundIndex using list's indexOf = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

//        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
//        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("Tens of Hearts replaced with tens of clubs");
        } else {
            System.out.println("No tens of Hearts found in the list");
        }

        System.out.println("Ten of Clubs Cards = " +
                Collections.frequency(deck, tenOfClubs));

        System.out.println("Best Card = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2);
        System.out.println("UnRotated: \n" + deck.subList(0, 13));
        System.out.println("Rotated " + 2 + ": \n" + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, -2);
        System.out.println("UnRotated: \n" + deck.subList(0, 13));
        System.out.println("Rotated " + -2 + ": \n" + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        int s = copied.size();
        for (int i = 0; i < s / 2; i++) {
            Collections.swap(copied, i, s - 1 - i);
        }
        System.out.println("Manual reverse: " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copied);
        System.out.println("Using reverse: "+copied);






    }
}