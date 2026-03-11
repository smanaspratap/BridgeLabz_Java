import java.util.*;

public class ObserverDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer a = new NewsChannel("Channel-A");
        Observer b = new NewsChannel("Channel-B");

        agency.register(a);
        agency.register(b);

        agency.setNews("Breaking: Observer Pattern working!");
    }
}

interface Observer {
    void update(String news);
}

interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyAllObservers();
}

class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyAllObservers();
    }

    public void register(Observer o) { observers.add(o); }
    public void unregister(Observer o) { observers.remove(o); }

    public void notifyAllObservers() {
        for (Observer o : observers) o.update(news);
    }
}

class NewsChannel implements Observer {
    private final String name;
    NewsChannel(String name) { this.name = name; }
    public void update(String news) {
        System.out.println(name + " received -> " + news);
    }
}