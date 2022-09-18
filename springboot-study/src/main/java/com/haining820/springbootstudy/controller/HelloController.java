package com.haining820.springbootstudy.controller;

import com.haining820.springbootstudy.mapper.StudentMapper;
import com.haining820.springbootstudy.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: hn.yu
 * Date: 2022-07-29
 * Time: 10:13
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello,SpringBoot!";
    }

    @Autowired
    Student student;

    @RequestMapping("/student")
    public String helloStudent() {
        return student.toString();
    }

    @Autowired
    private TransactionTemplate transactionTemplate;


    public void testTran() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper mapper = context.getBean("studentMapper", StudentMapper.class);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {
//                try {
                for (Student s : mapper.selectStudent()) {
                    System.out.println(s.toString());
                }
//                    Student student = new Student("testInTrans29", 29);
//                    LOGGER.error("add->" + studentMapper.addStudent(student));
//                    LOGGER.info("delete ->" + studentMapper.deleteStudent(100));
//                    LOGGER.error("select ->" + studentMapper.selectStudent());
//                } catch (Exception e) {
//                    status.setRollbackOnly();
//                    throw e;
//                }
            }
        });
    }

    public void tsetTeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloController controller = context.getBean("helloController", HelloController.class);
        controller.testTran();
    }


}
