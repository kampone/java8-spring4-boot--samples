package notemates;

import org.junit.*;

public class TestService{

    @Test
    public void testMessage(){
        Service service = new Service();
        String quote = service.sayQuote();
        Assert.assertEquals("2b||!2b", quote);
    }

}