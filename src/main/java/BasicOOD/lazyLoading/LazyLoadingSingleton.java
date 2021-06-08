package BasicOOD.lazyLoading;

public class LazyLoadingSingleton {
    private LazyLoadingSingleton() {}
    private static class LazyHolder {
        static final LazyLoadingSingleton INSTANCE = new LazyLoadingSingleton();
    }
    public static LazyLoadingSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}