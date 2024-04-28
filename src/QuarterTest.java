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
        // Arrange

        // Act

        // Assert
    }
    @Test
    public void testEquals(){
        // Arrange

        // Act

        // Assert
    }
    @Test
    public void testGetFirstMillisecond(){
        // Arrange
        Date date = new Date(1714306688938L);
        Quarter quarter = new Quarter(date);
        // Act

        // Assert
    }
    @Test
    public void testGetFirstMillisecond(Calendar calendar){
        // Arrange

        // Act

        // Assert
    }
    @Test
    public void testGetLastMillisecond(){
        // Arrange

        // Act

        // Assert
    }
    @Test
    public void testGetLastMillisecond(Calendar calender){
        // Arrange

        // Act

        // Assert        
    }
    @Test
    public void testGetQuarter(){
        // Arrange

        // Act

        // Assert
    }
    @Test
    public void testGetSerialIndex(){
        // Arrange

        // Act

        // Assert
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
        // Arrange

        // Act

        // Assert        
    }
    @Test
    public void testNext(){
        // Arrange

        // Act

        // Assert        
    }
    @Test
    public void testParseQuarter(){
        // Arrange

        // Act

        // Assert
    }
    @Test
    public void testPeg(){
        // Arrange

        // Act

        // Assert
    }
    @Test
    public void testPrevious(){
        // Arrange

        // Act

        // Assert
    }
    @Test
    public void testToString(){
        // Arrange

        // Act

        // Assert
    }
}
