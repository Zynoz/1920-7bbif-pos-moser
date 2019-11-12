package at.spengergasse.pos7bbif.foundation;

import org.junit.jupiter.api.Test;

import static at.spengergasse.pos7bbif.foundation.Ensurer.ensureNotNull;
import static org.assertj.core.api.Assertions.assertThat;

class EnsurerTest {

    @Test
    void verifyEnsureNotNullWorksProperlyForNonNullValue() {
        String name = "name";

        String result = ensureNotNull(name);

        assertThat(result).isNotNull().isSameAs(name);
    }

    @Test
    void verifyEnsureNotNullWorksProperlyForNullValue() {
        String stringValue = null;
        String name = "name";


    }

}