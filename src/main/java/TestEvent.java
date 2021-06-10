import nl.iobyte.eventapi.interfaces.IExecutable;

public class TestEvent implements IExecutable {

    private final String str;

    public TestEvent(String str) {
        this.str = str;
    }

    public String getData() {
        return str;
    }

}
