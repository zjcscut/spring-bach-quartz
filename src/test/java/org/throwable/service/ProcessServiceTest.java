package org.throwable.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.throwable.Application;

import static org.junit.Assert.*;

/**
 * @author zhangjinci
 * @version 2017/2/10 19:04
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ProcessServiceTest {

    @Autowired
    private ProcessService processService;

    @Test
    public void Test1()throws Exception{
        processService.process();
    }
}