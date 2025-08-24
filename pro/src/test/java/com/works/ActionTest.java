package com.works;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ActionTest {

    Random random = null;
    @BeforeAll
    void beforeAll() {
        random = new Random();
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @Test
    void call1() {
        System.out.println("call1 :" + random.nextInt(10));
    }

    @Test
    void call2() {
        System.out.println("call2 :" + random.nextInt(10));
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }

    @AfterAll
    void afterAll() {
        System.out.println("AfterAll");
    }

}
