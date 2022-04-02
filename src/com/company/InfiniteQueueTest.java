package com.company;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class InfiniteQueueTest {
    InfiniteQueue<Object> queue;
    Object o1 = 10;
    Object o2 = "test";
    Object o3 = true;

    @BeforeEach
    void setUp() {
        queue = new InfiniteQueue<>();
    }

    @AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(o1);
        assertFalse(queue.isEmpty());
        queue.enqueue(o2);
        assertFalse(queue.isEmpty());
    }

    @Test
    void enqueue() throws EmptyQueueException {
        queue.enqueue(o1);
        queue.enqueue(o2);

        assertEquals(o1, queue.dequeue());
        assertEquals(o2, queue.dequeue());
    }

    @Test
    void dequeue() throws EmptyQueueException {
        assertThrows(EmptyQueueException.class, () -> {
            queue.dequeue();
        });

        queue.enqueue(o1);
        queue.enqueue(o2);
        queue.enqueue(o3);

        assertEquals(o1, queue.dequeue());
        assertEquals(o2, queue.dequeue());
        assertEquals(o3, queue.dequeue());
        assertTrue(queue.isEmpty());

        assertThrows(EmptyQueueException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void first() throws EmptyQueueException {
        assertThrows(EmptyQueueException.class, () -> {
            queue.first();
        });

        queue.enqueue(o1);
        queue.enqueue(o2);
        queue.enqueue(o3);

        assertEquals(o1, queue.first());
    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        queue.enqueue(o1);
        queue.enqueue(o2);
        queue.enqueue(o3);
        assertEquals(3, queue.size());
    }
}