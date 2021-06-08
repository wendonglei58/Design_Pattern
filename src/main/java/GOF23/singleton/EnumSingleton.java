package GOF23.singleton;

public enum EnumSingleton {
    INSTANCE("only value");

    private String value;

    private EnumSingleton(String v) {
        this.value = v;
    }
}
