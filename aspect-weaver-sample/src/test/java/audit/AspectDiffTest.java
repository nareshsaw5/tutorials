package audit;

import org.testng.annotations.Test;

@Test
public class AspectDiffTest {

    @Test
    public void test() {
        SecuredMethod service = new SecuredMethod();
        service.unlockedMethod();
        service.lockedMethod();
        System.out.println("done");
    }
}
