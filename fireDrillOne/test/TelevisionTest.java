import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TelevisionTest {
    private Television television;

    @BeforeEach
    public void initialiazeTv(){
        television = new Television();
    }

    @Test
    public void turnAcOn_AcIsOnTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
    }

    @Test
    public void turnAcOff_AcIsOffTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        television.toggle();
        assertFalse(television.isTvOn());

    }

    @Test
    public void increaseVolume_volumeIncreasesByOneTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        assertEquals(0, television.getVolume());

        television.increaseVolume();
        assertEquals(1, television.getVolume());
        television.increaseVolume();
        assertEquals(2, television.getVolume());

    }

    @Test
    public void decreaseVolume_volumeDecreasesByOneTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        assertEquals(0, television.getVolume());

        for(int count = 1; count <= 5; count++){
            television.increaseVolume();
        }
        assertEquals(5, television.getVolume());
        television.decreaseVolume();
        assertEquals(4, television.getVolume());
        television.decreaseVolume();
        assertEquals(3, television.getVolume());
    }

    @Test
    public void increaseVolumeBeyondTen_volumeRemainsUnchangedTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        assertEquals(0, television.getVolume());

        for(int count = 1; count <= 13; count++){
            television.increaseVolume();
        }
        assertEquals(10, television.getVolume());
        television.increaseVolume();
        assertEquals(10, television.getVolume());
    }

    @Test
    public void decreaseVolumeBeyondZero_volumeRemainsUnchangedTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        assertEquals(0, television.getVolume());
        television.decreaseVolume();
        television.decreaseVolume();
        assertEquals(0, television.getVolume());
    }

    @Test
    public void increaseChannel_channelIncreasesByOneTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        assertEquals(1,  television.getChannel());
        television.increaseChannel();
        television.increaseChannel();
        assertEquals(3,  television.getChannel());

    }

    @Test
    public void decreaseChannel_channelDecreasesByOneTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        assertEquals(1,  television.getChannel());
        television.increaseChannel();
        television.increaseChannel();
        assertEquals(3,  television.getChannel());
        television.decreaseChannel();
        assertEquals(2, television.getChannel());
    }

    @Test
    public void increaseChannelBeyondTen_channelMovesBackToOneTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        assertEquals(1,  television.getChannel());
        for (int count = 1; count <= 9; count++){
            television.increaseChannel();
        }
        assertEquals(10,  television.getChannel());
        television.increaseChannel();
        assertEquals(1,  television.getChannel());
        television.increaseChannel();
        assertEquals(2,  television.getChannel());

    }

    @Test
    public void decreaseChannelBeyondOne_channelMovesToTenTest(){
        assertFalse(television.isTvOn());
        television.toggle();
        assertTrue(television.isTvOn());
        assertEquals(1,  television.getChannel());
        television.decreaseChannel();
        assertEquals(10,  television.getChannel());
        television.decreaseChannel();
        assertEquals(9,  television.getChannel());

    }
    
}

