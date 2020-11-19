package com.dodo;

public class Test {

    public static void main(String[] args) {
        SubOrder obj = new SubOrder();
    }
}

class OrderInit {



    static TestOrder obj1 = new TestOrder(1);

    TestOrder obj2 =  new TestOrder(10);

    public OrderInit(){
        System.out.println("OrderInit");
    }
}



class SubOrder extends  OrderInit {

    static TestOrder obj3 = new TestOrder(20) ;

    SubOrder(){
        System.out.println("Suborder ");
    }

}

class TestOrder {

    TestOrder ( int i){
        System.out.println("Test Order " +i);
    }

}
