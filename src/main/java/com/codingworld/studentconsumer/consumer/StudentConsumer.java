package com.codingworld.studentconsumer.consumer;

import com.codingworld.studentconsumer.Student;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentConsumer
{

  @PostConstruct
  public void consumer()
  {
    String url = "http://localhost:8012/getStudent";
    RestTemplate template = new RestTemplate();
    ResponseEntity<List<Student>> students =template.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
        new ParameterizedTypeReference<List<Student>>()
        {
          @Override
          public Type getType()
          {
            return super.getType();
          }
        });
    List<Student> list=students.getBody();
    System.out.println("Size:"+list.size());
    if(list.size()>0) {
      for(Student st:list) {
        System.out.println("id:"+st.getId()+"name:"+st.getName());
      }
    }
  }

}
