import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.sql.Date;

import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Year;
import org.junit.Test;
import java.util.Calendar;

// 1900 - 9999
public class QuarterTest {
    // Constructors Test
    @Test
    public void testConstructorDateParam(){
        // Arrange
        // That long 1714306688938L is the milliseconds for 28/april/2024 since 1970 "epoch" so I Asserted with the year
        Date date = new Date(1714306688938L);
        Year year = new Year(2024);
        
        // Act
        Quarter quarter = new Quarter(date);
        
        // Assert
        assertEquals(year, quarter.getYear());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2IntParamOutOfRange(){
        // Arrange Act
        Quarter quarter1 = new Quarter(4, 10000);
        Quarter quarter2 = new Quarter(-1, 2024);
        Quarter quarter3 = new Quarter(5, 2024);
        Quarter quarter4 = new Quarter(2, 1700);

        // Assert
        assertEquals(10000, quarter1.getYear().getYear());
        assertEquals(4, quarter1.getQuarter());
    
        assertEquals(2024, quarter2.getYear().getYear());
        assertEquals(-1, quarter2.getQuarter());

        assertEquals(2024, quarter3.getYear().getYear());
        assertEquals(5, quarter3.getQuarter());

        assertEquals(1700, quarter4.getYear().getYear());
        assertEquals(2, quarter4.getQuarter());
    }
    @Test
    public void testConstructor2IntParam() {
        // Arrange
        int quarterIndex = 3;
        Year year = new Year(2024);

        // Act
        Quarter quarter = new Quarter(quarterIndex, year);

        // Assert
        assertEquals(quarterIndex, quarter.getQuarter());
        assertEquals(year, quarter.getYear());
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
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIntandYearParamOutOfRange() {
        // Arrange Act
        Year year1 = new Year(10000);
        Year year2 = new Year(2024);
        Year year3 = new Year(1932);
        Year year4 = new Year(1700);
        
        Quarter quarter1 = new Quarter(4, year1);
        Quarter quarter2 = new Quarter(-1, year2);
        Quarter quarter3 = new Quarter(5, year3);
        Quarter quarter4 = new Quarter(2, year4);

        // Assert
        assertEquals(year1, quarter1.getYear().getYear());
        assertEquals(4, quarter1.getQuarter());
    
        assertEquals(year2, quarter2.getYear().getYear());
        assertEquals(-1, quarter2.getQuarter());

        assertEquals(year3, quarter3.getYear().getYear());
        assertEquals(5, quarter3.getQuarter());

        assertEquals(year4, quarter4.getYear().getYear());
        assertEquals(2, quarter4.getQuarter());
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
        // Assert
        assertEquals(8098, quarter.getSerialIndex(), 0);
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
    public void testHashCodeNoRepitition(){
        // Arrange
        Date date1 = new Date(1714306688938L);
        Date date2 = new Date(1722187734000L);
        // Act
        Quarter quarter1 = new Quarter(date1);
        Quarter quarter2 = new Quarter(date2);
        // Assert
        // Making sure it's a different hash value
        assertNotSame(quarter1.hashCode(), quarter2.hashCode());
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
    @Test(expected = IllegalArgumentException.class)
    public void testNextUpperBound(){
        // Arrange Act
        RegularTimePeriod time = new Quarter(1,10000);
        Quarter quarter = new Quarter(4,9999);
        // Assert        
        // next of Q4 should be Q1 of next year
        assertEquals(time, quarter.next());
    }
    @Test
    public void testPrevious(){
        // Arrange
        Date dateQ1 = new Date(1714306688938L); // Q2 2024
        Date dateQ2 = new Date(1722187734000L); // Q3 2024
        // Act
        RegularTimePeriod time = new Quarter(dateQ1);
        Quarter quarter = new Quarter(dateQ2);
        // Assert        
        assertEquals(time, quarter.previous());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPreviousLowerBound(){
        // Arrange Act
        RegularTimePeriod time = new Quarter(4,1899);
        Quarter quarter = new Quarter(1,1900);
        // Assert        
        assertEquals(time, quarter.previous());
    }
}
