package tests.lesson_16;

import models.UserBuilderLombok;
import models.User_Lombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LombokTest {

    @Test
    public  void  lombokToStringTest(){
        User_Lombok user_lombok = new User_Lombok("Anna", "Grabovskaya");
        System.out.println(user_lombok.toString());
    }

    @Test
    public  void  lombokEqualsTest(){
        User_Lombok user_lombok = new User_Lombok("Anna", "Grabovskaya");
        User_Lombok user_lombok2 = new User_Lombok("Anna", "Grabovskaya");
        user_lombok.setFirstName("Ann");
        user_lombok2.setFirstName("Ann");

        Assert.assertEquals(user_lombok, user_lombok2);
    }

    @Test
    public  void  lombokBuilderTest(){
        UserBuilderLombok userBuilderLombok = UserBuilderLombok.builder()
                .firstName("Ann")
                .lastName("Grabovskaya")
                .build();

        UserBuilderLombok userBuilderLombok2 = UserBuilderLombok.builder()
                .firstName("Ann")
                .lastName("Grabovskaya")
                .build();

        Assert.assertEquals(userBuilderLombok, userBuilderLombok2);
    }


}
