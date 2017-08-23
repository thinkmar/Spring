package com.imooc.test.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.imooc.bean.BeanScope;
import com.imooc.test.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanScope extends UnitTestBase {

    public TestBeanScope() {
        super("classpath*:resources/spring-beanscope.xml");
    }

    /**
     *  scope="singleton"时，输出的hashCode相同
     *  scope="prototype"时，输出的hashCode不同
     */
    @Test
    public void testSay() {
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();

        BeanScope beanScope2 = super.getBean("beanScope");
        beanScope2.say();
    }

    /**
     * scope="singleton"时,同时运行testSay(),testSay2()两个函数输出的hashCode不同
     * 因为每个方法执行前都会初始化一个ApplicationContext
     */
    @Test
    public void testSay2() {
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();
    }
}
