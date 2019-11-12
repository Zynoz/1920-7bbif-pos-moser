package at.spengergasse.pos7bbif.foundation;

public class Ensurer {

    private static final String ARGUMENT = "argument";

    public static <T> T ensureNotNull(T t) {
        return ensureNotNull(t, ARGUMENT);
    }

    public static <T> T ensureNotNull(T t, String name) {
        if (t == null) throw new IllegalArgumentException(String.format("%s must not be null!", name));
        return t;
    }

    public static String ensureNotBlank(String stringValue) {
        return ensureNotBlank(stringValue, ARGUMENT);
    }

    public static String ensureNotBlank(String stringValue, String name) {
        if (ensureNotNull(stringValue).isEmpty()) throw new IllegalArgumentException(String.format("%s must not be blan but was %s", name, stringValue));
        return stringValue;
    }

    public static Integer ensureNotNegative(Integer integer) {
        return ensureNotNegative(integer, ARGUMENT);
    }

    public static Integer ensureNotNegative(Integer integer, String name) {
        if (integer < 0) {
            throw new IllegalArgumentException(String.format("%s must not be negative but was %d", name, integer));
        }
        return integer;
    }
}
