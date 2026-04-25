package pack4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class Serialization {

    //Serialization: Converting Pojo class object to json object
    //De-Serialization: Converting Json object to Pojo class object
    //Here Pojo object is java object

    //Serialization
    @Test
    void convertPojoToJson() throws JsonProcessingException {

        //created java object using pojo class
       student pojo=new student();

       pojo.setName("john");
       pojo.setLocation("india");
       pojo.setPhone("123456");
       String courses[]={"java","selenium"};
       pojo.setCourses(courses);

        ObjectMapper objMapper=new ObjectMapper();
        String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
        System.out.println(jsonData);
    }
}

