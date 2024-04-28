import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Year;
import org.junit.Test;
import java.util.Calendar;

public class QuarterTest {
    // Constructors Test
    @Test
    public void testConstructorNoParam(){
        //
    }
    @Test
    public void testConstructorDateParam(){
        // Arrange
        // That long 1714306688938L is the milliseconds for 28/april/2024 since 1970 "epoch" so I Asserted with the year
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
    // Methods Test
    @Test
    public void testGetFirstMillisecond(){
        // Arrange
        long epochTimeMillis = 1704067200000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(epochTimeMillis);

        int q = (calendar.get(Calendar.MONTH) / 3) + 1;
        int year = calendar.get(Calendar.YEAR);
        int month = (q - 1) * 3;

        Quarter quarter = new Quarter(q, year);
        
        // Set to the first millisecond of the quarter
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        // Act
        long firstMillisecondOfQuarter = calendar.getTimeInMillis();

        // Assert
        assertEquals(firstMillisecondOfQuarter,quarter.getFirstMillisecond(), 0);
    }
    @Test
    public void testGetFirstMillisecond_CalendarParam(){
        // Arrange
        long epochTimeMillis = 1704067200000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(epochTimeMillis);

        int q = (calendar.get(Calendar.MONTH) / 3) + 1;
        int year = calendar.get(Calendar.YEAR);
        int month = (q - 1) * 3;

        Quarter quarter = new Quarter(q, year);
        
        // Set to the first millisecond of the quarter
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        // Act
        long firstMillisecondOfQuarter = calendar.getTimeInMillis();

        // Assert
        assertEquals(firstMillisecondOfQuarter,quarter.getFirstMillisecond(calendar), 0);
    }
    @Test
    public void testGetLastMillisecond(){
        // Arrange
        long epochTimeMillis = 1704067200000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(epochTimeMillis);

        int q = (calendar.get(Calendar.MONTH) / 3) + 1;
        int year = calendar.get(Calendar.YEAR);
        int month = (q - 1) * 3 + 2; // Last month of the quarter

        Quarter quarter = new Quarter(q, year);
        
        // Set to the last millisecond of the quarter
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        // Act
        long lastMillisecondOfQuarter = calendar.getTimeInMillis();
        // Assert
        assertEquals(lastMillisecondOfQuarter,quarter.getLastMillisecond(), 0);
    }
    @Test
    public void testGetLastMillisecond_CalendarParam(){
        // Arrange
        long epochTimeMillis = 1704067200000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(epochTimeMillis);

        int q = (calendar.get(Calendar.MONTH) / 3) + 1;
        int year = calendar.get(Calendar.YEAR);
        int month = (q - 1) * 3 + 2; // Last month of the quarter

        Quarter quarter = new Quarter(q, year);
        
        // Set to the last millisecond of the quarter
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        // Act
        long lastMillisecondOfQuarter = calendar.getTimeInMillis();
        // Assert
        assertEquals(lastMillisecondOfQuarter,quarter.getLastMillisecond(calendar), 0);      
    }
    @Test
    public void testGetQuarter(){
        // Arrange
        Date date = new Date(1714306688938L);
        // Act
        Quarter quarter = new Quarter(date);
        // Assert
        assertEquals(2,quarter.getQuarter(),0);
    }
    @Test
    public void testGetSerialIndex(){
        // Arrange
        Date date = new Date(1714306688938L);
        // Act
        Quarter quarter = new Quarter(date);
        int x = quarter.getYear().getYear() * 4 + quarter.getQuarter();
        // Assert
        assertEquals(x, quarter.getSerialIndex(), 0);
    }
    @Test
    public void testGetYear(){
        // Arrange
        Year year = new Year(2024);
        // Act
        Quarter quarter = new Quarter(0,year);
        // Assert
        assertEquals(year, quarter.getYear());
    }
    @Test
    public void testHashCode(){
        // Arrange
        Date date = new Date(1714306688938L);
        // Act
        Quarter quarter = new Quarter(date);
        // Assert
        assertNotNull(quarter.hashCode());        
    }
    @Test
    public void testNext(){
        // Arrange
        Date dateQ1 = new Date(1714306688938L);
        Date dateQ2 = new Date(1722187734000L);
        // Act
        RegularTimePeriod time = new Quarter(dateQ2);
        Quarter quarter = new Quarter(dateQ1);
        // Assert        
        assertEquals(time, quarter.next());
    }
    @Test
    public void testPrevious(){
        // Arrange
        Date dateQ1 = new Date(1714306688938L);
        Date dateQ2 = new Date(1722187734000L);
        // Act
        RegularTimePeriod time = new Quarter(dateQ1);
        Quarter quarter = new Quarter(dateQ2);
        // Assert        
        assertEquals(time, quarter.previous());
    }
}
