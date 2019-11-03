package myObserver1;

import java.util.ArrayList;
import java.util.List;

public class Newsletter implements IObservable {

    private String newsText;

    private List<IObserver> subscriberList = new ArrayList<>();

    public String getNews(){
        return newsText;
    }

    public void setNewsText(String txt){
        this.newsText = txt;
        notifyListeners();
    }


    @Override
    public void addListener(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void removeListener(Subscriber subscriber) {
        subscriberList.remove(subscriber);

    }

    @Override
    public void notifyListeners() {
        for (IObserver s: subscriberList ) {
            s.update(this);
        }
    }


}
