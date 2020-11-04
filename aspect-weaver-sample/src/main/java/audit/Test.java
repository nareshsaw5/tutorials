package audit;

public class Test {

    public static void main (String[] arg){
        SecuredMethod service = new SecuredMethod();
        service.unlockedMethod();
        service.lockedMethod();
        System.out.println("done");
    }
}
