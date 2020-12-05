package Archive;

public class Swimming implements Answers{

    @Override
    public String like() {
        System.out.println("I love swimming!");
        return "I love swimming!";
    }

    @Override
    public String knowAbout() {
        System.out.println("Swimming is a very active sport. The muscles of the whole body will be practiced during swimming.");
        return "Swimming is a very active sport. The muscles of the whole body will be practiced during swimming.";
    }

    @Override
    public String habit() {
        System.out.println("Don't forget to warm up before playing basketball!");
        return "Don't forget to warm up before playing basketball!";
    }
}