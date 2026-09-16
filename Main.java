import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Task-4: Club
 * The doorman Bruno at the popular night club Heaven is having a hard time
 * fulfilling his duties. He was told by the owner that when the club is full,
 * the number of women and men let into the club should be roughly the same.
 * When the night club opens, people wanting to enter the club are already
 * lined up in a queue, and Bruno can only let them in one-by-one. He lets
 * them in more-or-less in the order they are lined up. He can however decide
 * to let the second person in the queue cut the line and slip into the club
 * before the person in front. This will no doubt upset the person first in
 * line, especially when this happens multiple times, but Bruno is quite a
 * big guy and is capable of handling troublemakers.
 *
 * Unfortunately though, he is not that strong on mental calculations under
 * these circumstances. He finds keeping track of the difference of the number
 * of women and number of men let into the club a challenging task. As soon
 * as the absolute difference gets too big, he loses track of his counting
 * and must declare to the party people remaining in the queue that the club
 * is full.
 *
 * Input: A string containing a positive integer (describing the largest
 * absolute difference between the number of women and number of men let
 * into the club that Bruno can handle) followed by a comma and then a
 * string consisting solely of the characters ’W’ and ’M’ of length at
 * most 100, describing the genders of the people in the queue, in order
 * of their arrival. The first character of this string is the gender
 * of the person first in line. You may assume that the club is large
 * enough to hold all the people in the queue.
 *
 * Output: The maximum number of people Bruno can let into the club
 * without losing track of his counting.
 */



class Bruno {
    private int women;
    private int men;
    private int maxDiff;

    //!!!I ADDED THESE SETTERS!!!/////////////////////////////////////////////////////////////////////////////////////////
    public void setMen(int men) {
        this.men = men;
    }

    public void setWomen(int women) {
        this.women = women;
    }

    //!!! I ADDED THESE GETTERS!!!////////////////////////////////////////////////////////////////////////////////////////
    public int getWomen() {
        return women;
    }

    public int getMen() {
        return men;
    }

    public int getMaxDiff() {
        return maxDiff;
    }
//!!! END OF MY ADDED CODE!!!///////////////////////////////////////////////////////////////////////////////////////

    //Bruno constructor (giving the instance variables in the class "Default" values)
    public Bruno(int maxDiff) {
        this.maxDiff = maxDiff;
        this.women = 0;
        this.men = 0;
    }




    //Bruno checking if the absolute value is less than or equal to maxDiff
    //basically him admitting if he got it in the bag or not
    public boolean canAdmit(char gender) {
        if (gender == 'W') {
            return Math.abs((women + 1) - men) <= maxDiff;
        } else {
            return Math.abs(women - (men + 1)) <= maxDiff;
        }
    }


    //Bruno letting the person into the club
    public void admit(char gender) {
        if (gender == 'W') women++;
        else men++;
    }


    //returning the amount of people in the club
    public int total() {
        return women + men;
    }
}


//---END OF BRUNO CLASS----------------------------------------------------------------------------------




//what does QueueHandler entail?
//
class QueueHandler {
    //!!!GETTERS AND SETTERS!!!//////////////////////////////////////////////////////////////////////////
    public Bruno getBruno() {
        return bruno;
    }

    public Queue<Character> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Character> queue) {
        this.queue = queue;
    }

    //---Making all your instance variables------------------------------------
    //making a bruno
    //this is making a private object of type Bruno called bruno
    private Bruno bruno;

    //queue is of type array list with characters in it
    private Queue<Character> queue;


    //---Constructor------------------------------------------------------------
    public QueueHandler(int maxDiff, String lineup) {
        bruno = new Bruno(maxDiff);

        //queue is a linked list but the way the elements go into the list is in queue logic?
        //which is FIFO
        queue = new LinkedList<>();

        //for as long as a character is in a String a character
        //put each character into a character array
        //ie it's turning the string to it's individual members
        for (char c : lineup.toCharArray()) {
            queue.add(c);
        }
    }


    //---Method process--------------------------------------------------------
    public int process() {

        //while there is something in the queue
        while (!queue.isEmpty()) {

            //first becomes the first person in the queue
            char first = queue.peek();
            if (bruno.canAdmit(first)) {    //if he can still handle it (basis on which the person can skip or not)
                bruno.admit(queue.poll());  //add 1 to the counter to male or female

            } else if (queue.size() > 1) {  //if the queue is bigger than 1 so it can let the second person in
                Iterator<Character> it = queue.iterator();  //allows for iteration through collection
                it.next(); // skip first
                char second = it.next(); // get second

                if (bruno.canAdmit(second)) {   //checks to see if he has the ability to admit the second person
                    queue.remove(second); // remove second but leave first
                    bruno.admit(second);    //adding to the counter of men or women
                } else {
                    break; // he cannot admit the first or the second
                }
            } else {
                break; // cannot admit anyone under whatever other circunstances
            }
        }
        return bruno.total();
    }

}

// Main class only to demonstrate usage
// it does not need testing
class ClubMain {
    public static void main(String[] args) {
        //Bruno b = new Bruno( 1.0);

        // Example input
        String input = "1,WWMWWMW";

        //splits the array at ,
        String[] parts = input.split(",");

        //turns the first part of the split as a primitive int
        int maxDiff = Integer.parseInt(parts[0]);

        //the rest of the split is the String of people
        String lineup = parts[1];

        //puts in the value of the maxDiff in the correct instance variable
        //also seperates the characters in the string into an array
        QueueHandler handler = new QueueHandler(maxDiff, lineup);


        int result = handler.process();

        System.out.println(result);
    }
}
