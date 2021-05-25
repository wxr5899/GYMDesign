import com.SEGroup80.IO.VideoJSONFileProcessor;
import com.SEGroup80.Pojo.BasicPojo.Video;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVideoJSONFileProcessor {


    @Test
    void testReadVideoFromFile() {

        Video video = (Video) new VideoJSONFileProcessor().readJSON("V1621838990601", 1).get(0);
        assertEquals("Dance 2min", video.getTitle());
        assertEquals("src/main/resources/com/SEGroup80/Video/Dance 2min.mp4", video.getVideoURL());
        assertEquals("Hi, there! This is a 2 minutes dance video. If you don't have much time at workplace, it will be a good choice when you are taking a short break.", video.getDescription());
        assertEquals(952, video.getHit());
        assertEquals("2021-05-24", video.getReleaseTime());

    }

}
