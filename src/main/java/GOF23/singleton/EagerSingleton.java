package GOF23.singleton;

public class EagerSingleton {
    private String a;
    private String b;
    private static final EagerSingleton INSTANCE = new EagerSingleton("","");

    private EagerSingleton(String a, String b){
        this.a = a;
        this.b = b;
    };

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

}
