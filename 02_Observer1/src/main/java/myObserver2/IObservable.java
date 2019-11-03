package myObserver2;

public interface IObservable {
    void addListener(IObserver subscriber);
    void removeListener(IObserver subscriber);
    void notifyListeners();
}
