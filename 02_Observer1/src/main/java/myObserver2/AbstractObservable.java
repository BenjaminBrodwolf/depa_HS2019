package myObserver2;

import java.util.ArrayList;
import java.util.List;

public class AbstractObservable implements IObservable {
    private List<IObserver> subscriberList = new ArrayList<>();

    @Override
    public void addListener(IObserver subscriber) {
        subscriberList.add(subscriber);
//        notifyListeners();
    }

    @Override
    public void removeListener(IObserver subscriber) {
        subscriberList.remove(subscriber);
//        notifyListeners();
    }

    @Override
    public void notifyListeners() {
        for (IObserver s: subscriberList ) {
            s.update(this);
//            s.update();
        }
    }
}
