package com.griesba.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Java100ConstructorTest {

    @Test
    void testConstructorCanHaveReturnType() {
        class Unicorn {
            private boolean alive;

            public boolean Unicorn() {
                this.alive = true;
                return true;
            }

            public Unicorn() {
            }

            public Unicorn(boolean alive) {
                this.alive = alive;
            }
        }

        Unicorn unicorn = new Unicorn();
        assertThat(unicorn.Unicorn()).isEqualTo(true);
    }
}
