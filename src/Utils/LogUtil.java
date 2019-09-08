/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Arrays;

/**
 *
 * @author Branch Hill
 */
public class LogUtil {

    /**
     *
     * @param ex
     */
    public static void Exception(Exception ex) {

        if (ex == null) {
            return;
        }

        String source = ex.getClass().toString();
        String stacktrace = Arrays.toString(ex.getStackTrace());
        String message = ex.getMessage();

        System.err.println("********** Exception **********");

        if (source != null) {
            System.err.println("Source: " + source);
        }

        if (message != null) {
            System.err.println("Message: " + message);
        }

        if (message != null) {
            System.err.println("Stack Trace: " + stacktrace);
        }

        System.err.println("*******************************");
    }

    public static void Error(String message) {

        if (message == null) {
            return;
        }

        System.err.println("[ERR]: " + message);
    }

    public static void Verbose(String message) {

        if (message == null) {
            return;
        }

        System.out.println("[VRB]: " + message);
    }
}
