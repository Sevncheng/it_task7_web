package cn.ssm.test;

import cn.ssm.entity.EmailCode;
import cn.ssm.entity.PhoneCode;
import cn.ssm.entity.Student;
import cn.ssm.service.EmailCodeService;
import cn.ssm.service.PhoneCodeService;
import cn.ssm.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

public class demo1 {

    @Test
    public void test111() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
       Student s = studentService.findById("4bc8ca3b161d4b13ad0abfb489ba6a8c");
       System.out.println(s.getStudentName());
    }
    @Test
    public void testss() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        EmailCodeService emailCodeService = (EmailCodeService) ac.getBean("emailCodeService");
        EmailCode e = new EmailCode();
        e.setCodeEmail("813936279@qq.com");
        e.setCodeTime(Long.parseLong("1509271444279"));
        int a = emailCodeService.count(e);
        System.out.println(a);
    }

    @Test
    public void test112(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        PhoneCodeService phoneCodeService = (PhoneCodeService) ac.getBean("phoneCodeService");
        PhoneCode p = new PhoneCode();
        p.setCodePhone("4455");
        p.setCodeTime(Long.parseLong("1509280706787"));
        System.out.println(phoneCodeService.count(p));
  /*     PhoneCode pp = new PhoneCode();
       pp.setCodeTime(new Date().getTime());
       pp.setCodePhone("4455");
       phoneCodeService.save(pp);*/
    }



}


