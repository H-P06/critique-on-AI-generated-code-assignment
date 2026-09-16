import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrunoTest {

    //---TESTING THE CONSTRUCTOR-----------------------------------------------------------------------

    //testing if the constructor works to put the values
    //for all instance variables in properly
    //this passes
    @org.junit.jupiter.api.Test
    void normalBrunoConstructor(){
        Bruno bruno = new Bruno(5);

        //maxDiff should be 5
        assertEquals(5, bruno.getMaxDiff());

        //instance variables should be 0
        assertEquals(0, bruno.getWomen());
        assertEquals(0, bruno.getMen());

    }

    //fail because there is no exception and we made it fail
    @org.junit.jupiter.api.Test
    void testBrunoConstructorZero() {

        try {
            Bruno bruno = new Bruno(0);
            fail("maxDiff cannot be zero");
        } catch (Exception e) {
            System.out.println("An exception was thrown so it's fine");
        }
    }

    //another fail because no exception and we made it fail
    @org.junit.jupiter.api.Test
    void testBrunoConstructorNegative() {
        try {
            Bruno bruno = new Bruno(-2);
            fail("maxDiff cannot be negative"); //we made it fail
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }

    //test if it implements max in maxDiff properly
    //should return true
    @org.junit.jupiter.api.Test
    void testBrunoMaxDiffMaxConstructor() {
        int max = Integer.MAX_VALUE;
        Bruno bruno = new Bruno(max);

        assertEquals(max, bruno.getMaxDiff());
        assertEquals(0, bruno.getWomen());
        assertEquals(0, bruno.getMen());

    }



    //test min which will pass but it shouldn't! it should fail
    //reality testing
    @org.junit.jupiter.api.Test
    void testBrunoMaxDiffMinConstructor() {
        int min = Integer.MIN_VALUE;
        Bruno bruno = new Bruno(min);
        assertEquals(min, bruno.getMaxDiff());
        assertEquals(0, bruno.getWomen());
        assertEquals(0, bruno.getMen());
    }


    //should fail
    @org.junit.jupiter.api.Test
    void testBrunoMaxDiffMinTCFConstructor() {
        int min = Integer.MIN_VALUE;

        try{
            Bruno bruno = new Bruno(min);
            fail("maxDiff cannot be negative");
        }catch (Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }







    //---ADMIT TESTS--------------------------------------------------------------------------------------------------
    //---TESTING FOR UPPERCASE W, M  AND RANDOM

    //---PERFECT CASE-------------------------------------------------------------------

    //return true
    @org.junit.jupiter.api.Test
    void testUppercaseAdmitWomen(){
        Bruno bruno = new Bruno(1);

        bruno.admit('W');
        assertEquals(1, bruno.getWomen());
    }


    //return true
    @org.junit.jupiter.api.Test
    void testUppercaseAdmitMen(){
        Bruno bruno = new Bruno(1);

        bruno.admit('M');
        assertEquals(1, bruno.getMen());
    }
//---ABNORMAL TESTS
    //behaviour testing
    //returns false
    @org.junit.jupiter.api.Test
    void testUppercaseAdmitRandomW(){
        Bruno bruno = new Bruno(1);

        bruno.admit('R');
        assertEquals(1, bruno.getWomen());
    }

    //behaviour testing
    //true
    @org.junit.jupiter.api.Test
    void testUppercaseAdmitRandomM(){
        Bruno bruno = new Bruno(1);

        bruno.admit('R');
        assertEquals(1, bruno.getMen());
    }

//---TCF TESTS--------------------------------------------------------------------------------
    //will fail and it should have passed because it should have
    //received and exception but didn't
    @org.junit.jupiter.api.Test
    void testUppercaseCanAdmitRandomTCF(){
        Bruno bruno = new Bruno(1);

        try{
            bruno.admit('R');
            fail("maxDiff cannot be negative");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }

    //---lowercase gender---------------------------------------------------------------------------------------------

    //behaviour test
    //this should fail because the counter only goes up when the input is capital W
    @org.junit.jupiter.api.Test
    void testLowercaseWCanAdmitWomen(){
        Bruno bruno = new Bruno(1);

        bruno.admit('w');
        assertEquals(1, bruno.getWomen());
    }

    //behaviour test
    //this passes because there is no else if
    @org.junit.jupiter.api.Test
    void testLowercaseWCanAdmitMen(){
        Bruno bruno = new Bruno(1);
        bruno.admit('w');
        assertEquals(1, bruno.getMen());
    }

    //testing behaviour
    //this should pass because there was no else if for 'M' so anything that isn't 'W' passes, directly testing the behaviour
    @org.junit.jupiter.api.Test
    void testLowercaseRandomAdmitMen(){
        Bruno bruno = new Bruno(2);
        bruno.admit('z');
        assertEquals(1, bruno.getMen());
    }


    //testing for random values that aren't 'W' or 'M'----------------------------------------------------------------
    //this should fail because there was no exception passed
    @org.junit.jupiter.api.Test
    void testLowercaseRandomAdmitException(){
        Bruno bruno = new Bruno(2);

        try {
            bruno.admit('z');
            fail("Bruno cannot admit a z");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }


    //testing behaviour
    //this fails because it can never add to the women counter because in order to add to it, the input must be 'W'
    @org.junit.jupiter.api.Test
    void testLowercaseRandomAdmitWomen(){
        Bruno bruno = new Bruno(2);
        bruno.admit('z');
        assertEquals(1, bruno.getWomen());
    }
//---TCF FOR LOWERCASE-----------------------------------------------------------------------
    @org.junit.jupiter.api.Test
    void testLowercaseWomenTCF(){
        Bruno bruno = new Bruno(2);
        try{
            bruno.admit('w');
            fail("lowercase w is not accepted");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }

    @org.junit.jupiter.api.Test
    void testLowercaseMenTCF(){
        Bruno bruno = new Bruno(2);
        try{
            bruno.admit('m');
            fail("lowercase w is not accepted");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }

    @org.junit.jupiter.api.Test
    void testLowercaseRandomTCF(){
        Bruno bruno = new Bruno(2);
        try{
            bruno.admit('w');
            fail("lowercase w is not accepted");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }




    //--space tests---------------------------------------------------------------------

    //will fail because exception isn't passed
    @org.junit.jupiter.api.Test
    void testSpaceAdmitTCF(){
        Bruno bruno = new Bruno(1);
        try {
            bruno.admit(' ');
            fail("Space cannot be a valid input");
        }catch (Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }

    //testing behaviour
    //returns true because anything that isn't 'W' is M
    @org.junit.jupiter.api.Test
    void testSpaceAdmit(){
        Bruno bruno = new Bruno(2);
        bruno.admit(' ');
        assertEquals(1, bruno.getMen());
    }





    //---CANADMIT TESTS-----------------------------------------------------------------------------------------------
    //SHOWING SURFACE LEVEL FUNCTIONALITY WORKS
    //testing behaviour
    //pass because ((women + 1) - men) <= 1
    @org.junit.jupiter.api.Test
    void testCanAdmitUppercaseWomen(){
        Bruno bruno = new Bruno(1);
        assertTrue(bruno.canAdmit('W'));
    }

    //testing behaviour
    //will pass
    @org.junit.jupiter.api.Test
    void testCanAdmitUppercaseMen(){
        Bruno bruno = new Bruno(1);
        assertTrue(bruno.canAdmit('M'));
    }

    //---UPPERCASE RANDO------------------------------------------------------------
    //will pass but it shouldn't
    @org.junit.jupiter.api.Test
    void testCanAdmitRandomUpper(){
        Bruno bruno = new Bruno(1);
        assertTrue(bruno.canAdmit('Z'));
    }



    //---lowercase------------------------------------------------------------------
    //behaviour testing
    //will pass (but count as men) should have thrown exception
    @org.junit.jupiter.api.Test
    void testCanAdmitLowercaseWomen(){
        Bruno bruno = new Bruno(1);
        assertTrue(bruno.canAdmit('w'));
        assertEquals(1, bruno.getMen());
    }

    //testing behaviour
    //will pass should have thrown exception
    @org.junit.jupiter.api.Test
    void testCanAdmitLowercaseMen(){
        Bruno bruno = new Bruno(1);
        assertTrue(bruno.canAdmit('m'));
        assertEquals(1, bruno.getMen());
    }

    //testing behaviour
    //still passes even though it shouldn't because (women - (men + 1)) <= 1 and z is considered a man
    @org.junit.jupiter.api.Test
    void testCanAdmitRandomLower(){
        Bruno bruno = new Bruno(1);
        assertTrue(bruno.canAdmit('z'));
    }

    //---EXCEPTION CHECKING---------------------------------------------------------------
    @org.junit.jupiter.api.Test
    void testCanAdmitLowercaseWomenTCF(){
        Bruno bruno = new Bruno(1);
        try {
            bruno.canAdmit('w');
            fail("Space cannot be a valid input");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }

    //fail
    @org.junit.jupiter.api.Test
    void testCanAdmitLowercaseMenTCF(){
        Bruno bruno = new Bruno(1);
        try {
            bruno.canAdmit('m');
            fail("Space cannot be a valid input");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }

    //fail
    @org.junit.jupiter.api.Test
    void testCanAdmitLowercaseRandoTCF(){
        Bruno bruno = new Bruno(1);
        try {
            bruno.canAdmit('z');
            fail("Space cannot be a valid input");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }

    //fail
    @org.junit.jupiter.api.Test
    void testCanAdmitUppercaseRandoTCF(){
        Bruno bruno = new Bruno(1);
        try {
            bruno.canAdmit('Z');
            fail("Space cannot be a valid input");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }
    }



    //---NEGATIVE COUNTS------------------------------------------------------------------------------
    //dont need assertEquals bc that would be testing your setter
    //---TCP NEGATIVE COUNTS---------------------------------------------------------------------------------
    @org.junit.jupiter.api.Test
    void negativeWomenTCP(){
        Bruno bruno = new Bruno(1);
        try{
            bruno.setWomen(-1);
            fail("Women cannot be a negative number");
        }catch (Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }

    @org.junit.jupiter.api.Test
    void negativeMenTCP(){
        Bruno bruno = new Bruno(1);
        try{
            bruno.setMen(-1);
            fail("Men cannot be a negative number");
        }catch (Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }


    @org.junit.jupiter.api.Test
    void negativeMinWomenTCP(){
        Bruno bruno = new Bruno(1);
        int min = Integer.MIN_VALUE;
        try{
            bruno.setWomen(min);
            fail("Women cannot be a negative number");
        }catch (Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }

    //MINVALUE
    @org.junit.jupiter.api.Test
    void negativeMinMenTCP(){
        Bruno bruno = new Bruno(1);
        int min = Integer.MIN_VALUE;
        try{
            bruno.setMen(min);
            fail("Men cannot be a negative number");
        }catch (Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }


    //---TEST CAN ADMIT--------------------------------------------------------------------------------------
    //Will pass because it doesn't exceed
    @org.junit.jupiter.api.Test
    void testCanAdmitMaxInt(){
        int maxInt = Integer.MAX_VALUE;
        Bruno bruno = new Bruno(maxInt);

        //can he admit these? yes
        assertTrue(bruno.canAdmit('W'));
        assertTrue(bruno.canAdmit('M'));

        //actually admits them
        bruno.admit('W');
        bruno.admit('M');

        //can he still admit this person? yes
        assertTrue(bruno.canAdmit('W'));
    }

    //Will pass I used assertFalse and it should be false because Bruno can never
    //admit anyone if his maxDiff is a negative
    @org.junit.jupiter.api.Test
    void testCanAdmitMinInt(){
        int minInt = Integer.MIN_VALUE;
        Bruno bruno = new Bruno(minInt);

        //can he admit these? no, and he will never be able to
        assertFalse(bruno.canAdmit('W'));
        assertFalse(bruno.canAdmit('M'));

        //can he still admit this person? never
        assertFalse(bruno.canAdmit('W'));
    }


    //---CAN ADMIT BUT NO EXCEPTION CHECKING BEFORE SO WE GOTTA DO IT AGAIN----------------------
    void testCanAdmitMinIntECPUpperW(){
        int minInt = Integer.MIN_VALUE;
        Bruno bruno = new Bruno(minInt);

        try{
            bruno.canAdmit('W');
            fail("Exception should've been thrown from the constructor so it wasn't");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }


    void testCanAdmitMinIntECPUpperM(){
        int minInt = Integer.MIN_VALUE;
        Bruno bruno = new Bruno(minInt);

        try{
            bruno.canAdmit('M');
            fail("Exception should've been thrown from the constructor so it wasn't");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }


    void testCanAdmitMinIntECPUpperRando(){
        int minInt = Integer.MIN_VALUE;
        Bruno bruno = new Bruno(minInt);

        try{
            bruno.canAdmit('Z');
            fail("Exception should've been thrown from the constructor so it wasn't");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }

    void testCanAdmitMinIntECPLowerW(){
        int minInt = Integer.MIN_VALUE;
        Bruno bruno = new Bruno(minInt);

        try{
            bruno.canAdmit('w');
            fail("Exception should've been thrown from the constructor so it wasn't");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }

    void testCanAdmitMinIntECPLowerM(){
        int minInt = Integer.MIN_VALUE;
        Bruno bruno = new Bruno(minInt);

        try{
            bruno.canAdmit('m');
            fail("Exception should've been thrown from the constructor so it wasn't");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }

    void testCanAdmitMinIntECPLowerRando(){
        int minInt = Integer.MIN_VALUE;
        Bruno bruno = new Bruno(minInt);

        try{
            bruno.canAdmit('z');
            fail("Exception should've been thrown from the constructor so it wasn't");
        }catch(Exception e){
            System.out.println("An exception was thrown so you're fine");
        }

    }



    }//end of bruno test class
