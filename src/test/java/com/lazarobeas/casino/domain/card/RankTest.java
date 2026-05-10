package com.lazarobeas.casino.domain.card;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void twoHasValue2() {
        Card two = new Card(Rank.TWO, Suit.DIAMONDS);
        assertThat(two.rank().value()).isEqualTo(2);
    }

    @Test
    void aceHasValue14() {
        Card ace = new Card(Rank.ACE, Suit.DIAMONDS);
        assertThat(ace.rank().value()).isEqualTo(14);
    }

    @Test
    void jackHasValue11() {
        Card jack = new Card(Rank.JACK, Suit.CLUBS);
        assertThat(jack.rank().value()).isEqualTo(11);
    }

    @Test
    void twoIsLessThanThree() {
        Card two = new Card(Rank.TWO, Suit.HEARTS);
        Card three = new Card(Rank.THREE, Suit.DIAMONDS);
        assertThat(two.rank().value()).isLessThan(three.rank().value());
    }

    @Test
    void deckHasThirteenRanks() {
        Rank[] allRanks = Rank.values();
        assertThat(allRanks.length).isEqualTo(13);
    }

    @Test
    void ranksAreDeclaredInAscendingValues() {
        Rank[] allRanks = Rank.values();
        assertThat(allRanks).isSorted();
    }
}
