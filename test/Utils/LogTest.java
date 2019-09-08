/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Branch Hill
 */
public class LogTest {

    public LogTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Exception method, of class Log.
     */
    @Test
    public void testException() {
        Exception ex = new Exception("Exception Log Test");
        Log.Exception(ex);
    }

    /**
     * Test of Error method, of class Log.
     */
    @Test
    public void testError() {
        String message = "Error Log Test";
        Log.Error(message);
    }

    /**
     * Test of Warning method, of class Log.
     */
    @Test
    public void testWarning() {
        String message = "Warning Log Test";
        Log.Warning(message);
    }

    /**
     * Test of Information method, of class Log.
     */
    @Test
    public void testInformation() {
        String message = "Information Log Test";
        Log.Information(message);
    }

    /**
     * Test of Debug method, of class Log.
     */
    @Test
    public void testDebug() {
        String message = "Debug Log Test";
        Log.Debug(message);
    }

    /**
     * Test of Verbose method, of class Log.
     */
    @Test
    public void testVerbose() {
        String message = "Verbose Log Test";
        Log.Verbose(message);
    }

}
