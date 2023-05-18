import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadioTest {

    @Test
    public void mustCreateRadioWithDefaultAttributes() {
        Radio radio = new Radio();

        Assertions.assertEquals(10, radio.getNumberOfStations());
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void mustCreateRadioWith15Stations() {
        Radio radio = new Radio(15);

        Assertions.assertEquals(15, radio.getNumberOfStations());
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void mustSetRadioStation() {
        Radio radio = new Radio(15);

        radio.setCurrentRadioStation(13);

        int expected = 13;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustSetNextStation() {
        Radio radio = new Radio(15);
        radio.setCurrentRadioStation(10);

        radio.next();

        int expected = 11;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustSetPreviousStation() {
        Radio radio = new Radio(15);
        radio.setCurrentRadioStation(14);

        radio.prev();

        int expected = 13;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustNotSetStationBelow0() {
        Radio radio = new Radio();

        radio.setCurrentRadioStation(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustNotSetStationOverMaxStation() {
        Radio radio = new Radio(15);

        radio.setCurrentRadioStation(16);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustSetStation0AfterLastWhenNext() {
        Radio radio = new Radio(15);
        radio.setCurrentRadioStation(14);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustSetLastStationAfter0WhenPrev() {
        Radio radio = new Radio(15);

        radio.prev();

        int expected = 14;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustSetVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(10);

        int expected = 10;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustIncreaseVolume() {
        Radio radio = new Radio();

        radio.increaseVolume();

        int expected = 1;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);

        radio.decreaseVolume();

        int expected = 9;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustNotManuallySetVolumeBelow0() {
        Radio radio = new Radio();

        radio.setCurrentVolume(-1);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustNotManuallySetVolumeOver100() {
        Radio radio = new Radio();

        radio.setCurrentVolume(101);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustNotIncreaseVolumeOver100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustNotDecreaseVolumeBelow0() {
        Radio radio = new Radio();

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}