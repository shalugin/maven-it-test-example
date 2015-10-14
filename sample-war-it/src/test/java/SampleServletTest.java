import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.Assert.assertEquals;

/**
 * @author Asus
 */
public class SampleServletTest {

    @Test
    public void testServlet() throws Exception {
        URL url = new URL("http://localhost:8080/sample-war/sample");
        URLConnection urlConnection = url.openConnection();
        try (InputStream inputStream = urlConnection.getInputStream();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            int i;
            while ((i = inputStream.read()) != -1) {
                byteArrayOutputStream.write(i);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            String content = new String(bytes);
            assertEquals("Guess who?", content);
        }
    }
}