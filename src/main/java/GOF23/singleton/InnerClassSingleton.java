package GOF23.singleton;

public class InnerClassSingleton {
    private InnerClassSingleton() {}

    public InnerClassSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
    static private class InstanceHolder{
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}
