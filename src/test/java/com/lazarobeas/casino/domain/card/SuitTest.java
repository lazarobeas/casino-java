package com.lazarobeas.casino.domain.card;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SuitTest {
    @Test
    void fourSuitsArePresent() {
        Suit[] allSuits = Suit.values();
        assertThat(allSuits.length).isEqualTo(4);
    }

    @Test
    void allSuitsAreDifferent() {
        Suit[] allSuits = Suit.values();
        assertThat(allSuits).doesNotHaveDuplicates();
    }
}
