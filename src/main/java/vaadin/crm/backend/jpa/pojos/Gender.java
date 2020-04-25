package vaadin.crm.backend.jpa.pojos;

/**
 * 'F' for female or 'M' for male.
 * */
public enum Gender {
    MALE('M'),
    FEMALE('F');

    private final char s;

    Gender(char s) {
        this.s = s;
    }

    /**
     * @param s accepts only 2 values 'F' or 'M'
     * */
    public static Gender valueOf(char s) {
        for (Gender g : values()) {
            if (g.s == s) {
                return g;
            }
        }
        return null;
    }
}
