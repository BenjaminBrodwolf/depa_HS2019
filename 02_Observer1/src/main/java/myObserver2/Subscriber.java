package myObserver2;

public class Subscriber implements IObserver {

    private String name;
//    private Newsletter newsletter;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(AbstractObservable source) {
        Newsletter newsletter = (Newsletter) source;
        System.out.println(name + " erhält: " + newsletter.getNews());
    }

//    @Override
//    public void update() {
//        System.out.println(name + " erhält: " + newsletter.getNews());
//    }
}
