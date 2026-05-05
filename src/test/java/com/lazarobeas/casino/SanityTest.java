package com.lazarobeas.casino;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SanityTest {

    @Test
    void mavenAndJUnitInstalledCorrectley() {
        int sum = 2;
        assertThat(sum).isEqualTo(sum);
    }
}