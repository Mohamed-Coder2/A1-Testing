import static org.junit.Assert.assertEquals;

import org.jfree.data.time.Quarter;
import org.junit.Test;

public class QuarterTest {
    @Test
    public void testConstructor() {
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
    public void testNotify(){
        
    } 
    @Test
    public void testNotifyAll(){
        
    }
    @Test
    public void testGetMilliSecond(){
        
    }

    @Test
    public void testGetSerialIndex(){
        
    }
    @Test
    public void testGetStart(){
        
    }
    @Test
    public void testGetYear(){
        Quarter quarter = new Quarter(0, 2024);
        
        assertEquals(2024, quarter.getYear().getYear());
    }
    @Test
    public void testHashCode(){
        
    }
    @Test
    public void testNext(){
        
    }
}
