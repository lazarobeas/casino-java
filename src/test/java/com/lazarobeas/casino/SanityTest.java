package com.lazarobeas.casino;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SanityTest {

    @Test
    void mavenAndJUnitInstalledCorrectly() {
        assertThat(1+1).isEqualTo(2);
    }
}