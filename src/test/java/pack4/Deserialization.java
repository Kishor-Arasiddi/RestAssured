package pack4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class Deserialization {

    //Serialization: Converting Pojo class object to json object
    //De-Serialization: Converting Json object to Pojo class object
    //Here Pojo object is java object

    //De-Serialization
    @Test
    void convertJsonToPojo() throws JsonProcessingException {

        String jsonData="{\r\n"
                +"\"name\" : \"john\",\r\n"
                +"\"location\" : \"india\",\r\n"
                +"\"phone\" : \"123456\",\r\n"
                +"\"courses\" :[ \"java\",\"selenium\" ]\r\n"
                +"}";

        ObjectMapper objectMapper=new ObjectMapper();
        student pojoData = objectMapper.readValue(jsonData, student.class);

        System.out.println("Name:"+pojoData.getName());
        System.out.println("Location:"+pojoData.getLocation());
        System.out.println("Phone:"+pojoData.getPhone());
        System.out.println("Course1:"+pojoData.getCourses()[0]);
        System.out.println("Course2:"+pojoData.getCourses()[1]);

    }
}
