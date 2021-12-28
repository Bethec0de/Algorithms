package codewars;

/**
 * Johnny is a farmer and he annually holds a beet farmers convention "Drop the beet".
 * <p>
 * Every year he takes photos of farmers handshaking. Johnny knows that no two farmers handshake more than once.
 * He also knows that some of the possible handshake combinations may not happen.
 * However, Johnny would like to know the minimal amount of people that participated this year just by counting all the handshakes.
 * Help Johnny by writing a function, that takes the amount of handshakes and returns the minimal amount of people
 * needed to perform these handshakes (a pair of farmers handshake only once).
 */
public class HandshakeProblem {

    int minPeople(int totalHandshakes) {
        int returnValue = 0;
        int counter = 1;

        while (returnValue < totalHandshakes) {
            returnValue += counter++;
        }
        return counter;
    }
}
