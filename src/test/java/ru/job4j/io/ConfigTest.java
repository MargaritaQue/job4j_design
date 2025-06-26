package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("#Comment")).isEqualTo(null);
        assertThat(config.value("name")).isEqualTo("Petr=Arsentev");
    }

    @Test
    void whenPairWithMistakes() {
        String path = "./data/pair_with_mistakes.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr=Arsentev");
    }

    @Test
    void whenPairWithEx() {
        String path = "./data/pair_with_mistakes2.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("breaking the pattern");
    }
}