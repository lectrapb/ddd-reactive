package tv.codely.shared.domain.value;

public abstract class StringValueObject {

    private final String value;

    public StringValueObject(String value) {
        checkIfNull(value);
        this.value = value;
    }

    private void checkIfNull(String value) {

        if (value == null) {
            throw new RuntimeException("Value is required");
        }
    }

    public String value(){
        return value;
    }

}
