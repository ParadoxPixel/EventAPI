import nl.iobyte.eventapi.ExecuteDriver;

public class Main {

    public static void main(String[] args) {
        ExecuteDriver driver = new ExecuteDriver();


        driver.on(TestEvent.class, event -> System.out.println(event.getData()))
                .on(TestEEvent.class, event -> System.out.println(event.getI()));

        driver.fire(new TestEvent("Nice Nice"));
        driver.fire(new TestEEvent("Nice", 1));

        //TODO Handle Parent's
    }

}
