package tests;


import annotations.Before_After_Annotations;
import org.testng.annotations.Test;


public class GroupHomeTest extends Before_After_Annotations {
    @Test(groups = "user1")
    public void testMethod1 (){
        int m = (int)(Math.random() * 10);
        System.out.println("User_1 with number " + m);
    }

    @Test(groups = "user1")
    public void testMethod2 (){
        int m = (int)(Math.random() * 10);
        System.out.println("User_1 with number " + m);
    }

    @Test(groups = "user1")
    public void testMethod3 (){
        int m = (int)(Math.random() * 10);
        System.out.println("User_1 with number " + m);
    }

    @Test (groups = "user2")
    public void testMethod4 (){
        int m = (int)(Math.random() * 10);
        System.out.println("User_2 with number " + m);
    }

    @Test(groups = "user2")
    public void testMethod5 (){
        int m = (int)(Math.random() * 10);
        System.out.println("User_2 with number " + m);
    }
}




