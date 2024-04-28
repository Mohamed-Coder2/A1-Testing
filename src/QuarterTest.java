import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.jfree.data.time.Quarter;
import org.jfree.data.time.Year;
import org.junit.Test;
import java.util.Calendar;

public class QuarterTest {
    //Constructors Test
    @Test
    public void testConstructorNoParam(){
        //
    }
    @Test
    public void testConstructorDateParam(){
        // Arrange
        // That long is the milliseconds for 28/april/2024 since 1970 "epoch" so I Asserted with the year
        Date date = new Date(1714306688938L);
        
        // Act
        Quarter quarter = new Quarter(date);
        
        // Assert
        assertEquals(2024, quarter.getYear().getYear());
    }
    @Test
    public void testConstructor2IntParam() {
        // Arrange
        int quarterIndex = 3;
        int year = 2022;

        // Act
        Quarter quarter = new Quarter(quarterIndex, year);

        // Assert
        assertEquals(quarterIndex, quarter.getQuarter());
        assertEquals(year, quarter.getYear().getYear());
    }
    @Test
    public void testConstructorIntandYearParam() {
        // Arrange
        int quarterIndex = 3;
        Year year = new Year(2024);

        // Act
        Quarter quarter = new Quarter(quarterIndex, year);

        // Assert
        assertEquals(quarterIndex, quarter.getQuarter());
        assertEquals(year, quarter.getYear());
    }
    // Test Methods
    @Test
    public void testCompareTo(){

    }
    @Test
    public void testEquals(){

    }
    @Test
    public void testGetFirstMillisecond(){

    }
    @Test
    public void testGetFirstMillisecond(Calendar calendar){

    }
    @Test
    public void testGetLastMillisecond(){

    }
    @Test
    public void testGetLastMillisecond(Calendar calender){
        
    }
    @Test
    public void testGetQuarter(){

    }
    @Test
    public void testGetSerialIndex(){

    }
    @Test
    public void testGetYear(){
        Year year = new Year(2024);
        Quarter quarter = new Quarter(0,year);
        
        assertEquals(year, quarter.getYear());
    }
    @Test
    public void testGetYearValue(){
        // Method exists in Docs but I can't call it
        // either it's private or doesn't exist
    }
    @Test
    public void testHashCode(){
        
    }
    @Test
    public void testNext(){
        
    }
    @Test
    public void testParseQuarter(){

    }
    @Test
    public void testPeg(){

    }
    @Test
    public void testPrevious(){

    }
    @Test
    public void testToString(){
        
    }
}
