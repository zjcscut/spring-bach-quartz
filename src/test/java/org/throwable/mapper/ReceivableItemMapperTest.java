package org.throwable.mapper;

import org.throwable.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.throwable.entity.ReceivableItem;

import static org.junit.Assert.*;

/**
 * @author zhangjinci
 * @version 2017/2/10 16:48
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ReceivableItemMapperTest {

    @Autowired
    private ReceivableItemMapper receivableItemMapper;

    @Test
    public void Test1()throws Exception{
        ReceivableItem receivableItem =  receivableItemMapper.fetchById(1L);

        assertNotNull(receivableItem);
    }

}