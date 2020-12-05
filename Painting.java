package Archive;

public class Painting implements Answers{
    @Override
    public String like() {
        return "I love painting!";
    }

    @Override
    public String knowAbout() {
        return "Drawing is not a easy task, it needs a long time practice.";
    }

    @Override
    public String habit() {
        return "I often appreciate famous paintings, which also helps to improve my aesthetics.";

    }
}