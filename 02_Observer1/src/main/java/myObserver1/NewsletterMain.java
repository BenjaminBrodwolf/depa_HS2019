package myObserver1;

public class NewsletterMain {

    public static void main(String[] args) {

        Newsletter newsletter = new Newsletter();
        Subscriber s1 = new Subscriber();
        Subscriber s2 = new Subscriber();

        newsletter.addListener(s1);
        newsletter.addListener(s2);

        newsletter.setNewsText("Erste");

    }
}
