package pack4;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.testng.annotations.Test;

public class FakerLibrary {

    //This library generate random data automatically

    @Test
    void testFakerApi(){

        Faker faker=new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        int digit = faker.number().randomDigit();
        String number = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();
        String pwd = faker.internet().password();

        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(digit);
        System.out.println(number);
        System.out.println(email);
        System.out.println(pwd);



    }
}
