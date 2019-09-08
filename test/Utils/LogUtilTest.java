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
public class LogUtilTest {

    public LogUtilTest() {
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
     * Test of Exception method, of class LogUtil.
     */
    @Test
    public void testException() {
        Exception ex = new Exception("Exception Log Test");
        LogUtil.Exception(ex);
    }

    /**
     * Test of Error method, of class LogUtil.
     */
    @Test
    public void testError() {
        String message = "Error Log Test";
        LogUtil.Error(message);
    }

    /**
     * Test of Verbose method, of class LogUtil.
     */
    @Test
    public void testVerbose() {
        String message = "Verbose Log Test";
        LogUtil.Verbose(message);
    }
}
