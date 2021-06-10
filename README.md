# EventAPI
Simple Java library to handle events without using 3rd party libraries

```java
//Example Event Class
public class TestEvent implements IExecutable {

    private final String str;

    public TestEvent(String str) {
        this.str = str;
    }

    public String getData() {
        return str;
    }

}

//Register Driver
ExecuteDriver driver = new ExecuteDriver();

//Register Event
driver.on(TestEvent.class, event -> System.out.println(event.getData()))

//Fire Event
driver.fire(new TestEvent("Nice Event"));
```
