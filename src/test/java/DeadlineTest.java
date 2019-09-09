import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void Deadline_test() throws ParseException {
        String w1 = "[D][\u2718] test deadline project meeting (by: Mon Dec 02 18:00:00 SGT 2019)";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date date = format.parse("2/12/2019 1800");
        String w2 = new Deadline("test deadline project meeting", date).toString();
        assertEquals(w1, w2);
    }
}
