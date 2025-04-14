package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkEqual() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"key:value", "key1=value1", "key2=value2"};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: key:value does not contain the symbol '='");
    }

    @Test
    void checkEqualStart() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"key=value", "=key1=value1", "key2=value2"};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: =key1=value1 does not contain a key");
    }

    @Test
    void checkEqualFinish() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"key=value", "key1=value1", "key2value2="};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: key2value2= does not contain a value");
    }

    @Test
    void checkNamesEmpty() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }
}