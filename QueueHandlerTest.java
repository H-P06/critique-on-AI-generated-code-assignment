import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;


class QueueHandlerTest {

    //---PERFECT CASE----------------------------------------------------------------------------------
    //should pass
    @org.junit.jupiter.api.Test
    void testQueueHandlerBrunoConstructor() {
        QueueHandler handler = new QueueHandler(3, "WMW");
        assertEquals(3, handler.getBruno().getMaxDiff());
    }

    //should pass
    @org.junit.jupiter.api.Test
    void testQueueHandlerLinkedListConstructor() {
        QueueHandler handler = new QueueHandler(3, "WMW");

        Queue<Character> queue = new LinkedList<>(Arrays.asList('W','M','W'));

        assertEquals(queue,handler.getQueue());
    }

    //---blank LINEUP--------------------------------------------------------------------------
    //passes but it should not
    @org.junit.jupiter.api.Test
    void testQueueHandlerQueueConstructorEmptyLineup() {
        QueueHandler handler = new QueueHandler(3, " ");
        Queue<Character> queue = new LinkedList<>(Arrays.asList(' '));
        assertEquals(queue,handler.getQueue());
    }

    //---BLANK LINEUP TCF-----------------------------------------------------------------------
   //will fail
    @org.junit.jupiter.api.Test
    void testQueueHandlerQueueConstructorEmptyQueueTCF() {
        try{
            new QueueHandler(3, " ");
            fail("Cannot have a blank lineup");
        }catch(Exception e){
            System.out.println("An exception was thrown so it's fine");
        }
    }

    //---LINEUP HAS ONLY 1----------------------------------------------
    //will pass
    @org.junit.jupiter.api.Test
    void testQueueHandlerQueueConstructorOnlyOne() {
        QueueHandler handler = new QueueHandler(3, "W");
        Queue<Character> queue = new LinkedList<>(Arrays.asList('W'));
        assertEquals(queue,handler.getQueue());
    }

    //---LINEUP IS 100--------------------------------------------------
    //should work because it can handle up to 100
    @org.junit.jupiter.api.Test
        void testQueueHandlerQueueConstructor100() {
        String result = "";

        //100 Ws
        for (int i = 0; i < 100; i++) {
            result += "W";
        }


        //make into queue
        Queue<Character> expectedQueue = new LinkedList<>();
        for (char c : result.toCharArray()) {
            expectedQueue.add(c);
        }

        QueueHandler handler = new QueueHandler(3, result);


        assertEquals(expectedQueue, handler.getQueue());
    }

    //---LINEUP IS 101--------------------------------------------------
    //it will work but in reality it shouldn't
    @org.junit.jupiter.api.Test
    void testQueueHandlerQueueConstructor101() {
        String result = "";

        //100 Ws
        for (int i = 0; i < 101; i++) {
            result += "W";
        }


        //make into queue
        Queue<Character> expectedQueue = new LinkedList<>();
        for (char c : result.toCharArray()) {
            expectedQueue.add(c);
        }

        QueueHandler handler = new QueueHandler(3, result);


        assertEquals(expectedQueue, handler.getQueue());
    }

    //---LINEUP IS MAX-----------------------------------------------
    //---HAVING NEGATIVE LINES IS LITERALLY IMPOSSIBLE----------------------------------
    //should fail but will pass
//    @org.junit.jupiter.api.Test
//    void testQueueHandlerQueueConstructorMAX() {
//        String result = "";
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            result += "W";
//        }
//
//        Queue<Character> expectedQueue = new LinkedList<>();
//
//        for (char c : result.toCharArray()) {
//            expectedQueue.add(c);
//        }
//
//        QueueHandler handler = new QueueHandler(3, result);
//        assertEquals(expectedQueue, handler.getQueue());
//    }


    //perfect case of everyone is admitted
    @org.junit.jupiter.api.Test
    void testProcessEveryoneAdmitted() {
        // Bruno can handle difference of 2
        QueueHandler handler = new QueueHandler(2, "MWM"); // lineup

        int total = handler.process();

        assertEquals(3, total); // everyone gets admitted
        assertTrue(handler.getQueue().isEmpty()); // queue should be empty
        assertEquals(2, handler.getBruno().getMen());
        assertEquals(1, handler.getBruno().getWomen());
    }

    //perfect case of nobody is admitted
    @org.junit.jupiter.api.Test
    void testProcessNobodyAdmit() {
        QueueHandler handler = new QueueHandler(0, "WW");

        int total = handler.process();

        assertEquals(0, total); // no one admitted
        assertEquals(2, handler.getQueue().size());
    }

    //admitting a random
    //still accepts z and makes it a man
    @org.junit.jupiter.api.Test
    void testProcessRandomAdmit() {
        QueueHandler handler = new QueueHandler(1, "zz");

        int total = handler.process();

        assertEquals(1, total); // no one admitted
        assertEquals(1, handler.getQueue().size());
        assertEquals(1, handler.getBruno().getMen());
    }





}//end of queuehandlertest class