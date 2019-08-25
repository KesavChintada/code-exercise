package com.code.exercise;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for PrimeMultiplicationTable.
 */
public class PrimeMultiplicationTableTest {
	private final PrintStream originalStdOut = System.out;
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private PrimeMultiplicationTable pmt=new PrimeMultiplicationTable();
    
    List<Integer>firstTenPrimes=null;
    
    String tableRow1="   X   2   3   5   7  11  13  17  19  23  29";
    String tableRow2="   2   4   6  10  14  22  26  34  38  46  58";
    String tableRow3="   3   6   9  15  21  33  39  51  57  69  87";
    String tableRow4="   5  10  15  25  35  55  65  85  95 115 145";
    String tableRow5="   7  14  21  35  49  77  91 119 133 161 203";
    String tableRow6="  11  22  33  55  77 121 143 187 209 253 319";
    String tableRow7="  13  26  39  65  91 143 169 221 247 299 377";
    String tableRow8="  17  34  51  85 119 187 221 289 323 391 493";
    String tableRow9="  19  38  57  95 133 209 247 323 361 437 551";
    String tableRow10="  23  46  69 115 161 253 299 391 437 529 667";
    String tableRow11="  29  58  87 145 203 319 377 493 551 667 841";
 
    @Before
    public void setUpStreams() {
    	mockResults();
    	System.setOut(new PrintStream(this.consoleContent));    	
    }
 
    @After
    public void revertStreams() {
    	System.setOut(this.originalStdOut);
    	// Clear the consoleContent.
        this.consoleContent = new ByteArrayOutputStream();
    }
    
    private void mockResults() {
    	firstTenPrimes=new ArrayList<Integer>();
    	firstTenPrimes.add(2);
    	firstTenPrimes.add(3);
    	firstTenPrimes.add(5);
    	firstTenPrimes.add(7);
    	firstTenPrimes.add(11);
    	
    	firstTenPrimes.add(13);
    	firstTenPrimes.add(17);
    	firstTenPrimes.add(19);
    	firstTenPrimes.add(23);
    	firstTenPrimes.add(29);
    }
    
    @Test
    public void testPrimeList()
    {    	
    	List<Integer>resultPrimes= pmt.primeList(10);
        assertTrue( resultPrimes.equals(firstTenPrimes) );
    }
    
    @Test
    public void testIsPrime()
    {        	
        assertTrue( PrimeMultiplicationTable.isPrime(13));
    }
    
    @Test
    public void testPrintPrimeMltplcnTbl()
    {        	
        pmt.printPrimeMltplcnTbl(pmt.primeList(10));
            
        assertTrue(this.consoleContent.toString().contains(tableRow1));
        assertTrue(this.consoleContent.toString().contains(tableRow2));
        assertTrue(this.consoleContent.toString().contains(tableRow3));
        assertTrue(this.consoleContent.toString().contains(tableRow4));
        assertTrue(this.consoleContent.toString().contains(tableRow5));
        assertTrue(this.consoleContent.toString().contains(tableRow6));
        assertTrue(this.consoleContent.toString().contains(tableRow7));
        assertTrue(this.consoleContent.toString().contains(tableRow8));
        assertTrue(this.consoleContent.toString().contains(tableRow9));
        assertTrue(this.consoleContent.toString().contains(tableRow10));
        assertTrue(this.consoleContent.toString().contains(tableRow11));        
    }
}
