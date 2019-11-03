package myObserver2;

public class ConsoleMessageObserver implements IObserver {

//    IObservable observable;

//    public ConsoleMessageObserver(Newsletter newsletter) {
//        this.observable = newsletter;
//    }


    @Override
    public void update(AbstractObservable source) {
        Newsletter newsletter = (Newsletter) source;
        System.out.println("Newsletter wurde verschickt: " + newsletter.getNews());
    }

//    @Override
//    public void update() {
//        Newsletter newsletter = (Newsletter) observable;
//        System.out.println("Newsletter wurde verschickt: " + newsletter.getNews());
//    }
}
