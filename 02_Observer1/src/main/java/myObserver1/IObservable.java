package myObserver1;

public interface IObservable {
    void addListener(Subscriber subscriber);
    void removeListener(Subscriber subscriber);
    void notifyListeners();
}
