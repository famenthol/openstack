package com.it.demo.demo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
		
	
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	String str = "aaaaaaa";
		int ANum = 0;
		int BNum = 0;
		char a = 'a';
		if (a == 'a') {System.out.println(true);}
		for (int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);
			if (temp == 'A') {
				ANum ++;
			}else if(temp == 'B') {
				BNum ++;
			}
		}
		int result;
		if (ANum ==0 || BNum ==0) {
			result = 0;
		}else {
			result = ANum > BNum ? BNum : ANum;
		}
		System.out.println(result);
        assertTrue( true );
    }
    
   
}
