import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void Event_test() throws ParseException {
        String w1 = "[E][\u2718] test event project meeting (at: Mon Dec 02 18:00:00 SGT 2019)";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date date = format.parse("2/12/2019 1800");
        String w2 = new Event("test event project meeting", date).toString();
        assertEquals(w1, w2);
    }
}
