/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Group 2
 */
public class SettingsTest {

    public SettingsTest() {
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
     * Test of GetSetting method, of class Settings.
     */
    @Test
    public void testAddAndGetSetting() {
        System.out.println("AddAndGetSetting Test");
        Session session = Session.getInstance();

        session.appSettings.addOrUpdateSetting("Test Key", "Test Value");
        String result = session.appSettings.getSetting("Test Key");

        assertEquals("Test Value", result);
    }

}
