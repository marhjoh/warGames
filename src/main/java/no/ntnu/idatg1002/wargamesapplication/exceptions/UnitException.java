package no.ntnu.idatg1002.wargamesapplication.exceptions;

/**
 * This is a class for throwing exception for the Unit class
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class UnitException extends RuntimeException {

    public UnitException(String message){
        super(message);
    }
}