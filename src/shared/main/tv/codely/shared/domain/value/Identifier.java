package tv.codely.shared.domain.value;

import java.util.UUID;

public abstract class Identifier {

    private final String value;

    public Identifier(String value) {

        ensureValidUuid(value);
        this.value = value;
    }

    private void ensureValidUuid(String value) {
        UUID.fromString(value);
    }

    public String value(){
        return value;
    }
}
