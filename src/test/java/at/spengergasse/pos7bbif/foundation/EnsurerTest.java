package at.spengergasse.pos7bbif.foundation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static at.spengergasse.pos7bbif.foundation.Ensurer.*;
import static at.spengergasse.pos7bbif.foundation.Ensurer.ensureNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EnsurerTest {

    private static final String NAME = "name";

    @Test
    void verifyEnsureNotNullWorksProperlyForNonNullValue() {

        String result = ensureNotNull(NAME);

        assertThat(result).isNotNull().isSameAs(NAME);
    }

    @Test
    void verifyEnsureNotNullWorksProperlyForNullValue() {
        String stringValue = null;

        IllegalArgumentException iaEx = assertThrows(IllegalArgumentException.class, () -> ensureNotNull(stringValue, NAME));

        assertThat(iaEx.getMessage())
                .startsWith(NAME)
                .contains("must not be null!");
    }

    @Test
    void verifyEnsureNotBlankWorksProperlyForNonWhitespaceValue() {
        assertThat(ensureNotBlank(NAME))
                .isNotNull()
                .isSameAs(NAME);
    }

    @ParameterizedTest(name = "[{index}]: must detect '{0}'")
    @ValueSource(strings = {"", " ", "  ", "\t", "\n", "\r", "\t \n \r"})
    void verifyEnsureNotBlankWorksProperlyForWhitespaceValue(String stringValue) {
        IllegalArgumentException iaEx = assertThrows(IllegalArgumentException.class, () -> ensureNotBlank(stringValue, NAME));

        assertThat(iaEx.getMessage())
                .startsWith(NAME)
                .contains("must not be blank but was");
    }

    @ParameterizedTest(name = "[{index}]: must detect negative value '{0}'")
    @ValueSource(ints = { -99, -2, -1 })
    void verifyEnsureNotNegativeWorksProperlyForNegativeValue(Integer integerValue) {
        IllegalArgumentException iaEx = assertThrows(IllegalArgumentException.class, () -> ensureNotNegative(integerValue, NAME));

        assertThat(iaEx.getMessage())
                .startsWith(NAME)
                .contains("must not be negative but was");
    }

    @ParameterizedTest(name = "[{index}]: must return valid value '{0}'")
    @ValueSource(ints = { 1, 2, 99 })
    void verifyEnsureNotNegativeWorksProperlyForValidValue(Integer integerValue) {

        assertThat(ensureNotNegative(integerValue, NAME)).isSameAs(integerValue);
    }
}