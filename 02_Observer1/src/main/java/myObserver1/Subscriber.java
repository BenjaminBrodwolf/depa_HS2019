package myObserver1;

public class Subscriber implements IObserver {

    @Override
    public void update(Newsletter source) {

        System.out.println(source.getNews());
    }
}
