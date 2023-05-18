public class Radio {

    private int currentRadioStation;
    private int currentVolume;
    private int numberOfStations = 10;

    public Radio() {
    }

    public Radio(int numberOfStations) {
        this.numberOfStations = numberOfStations;
    }

    public void next() {
        if (currentRadioStation == (numberOfStations - 1)) {
            currentRadioStation = 0;
            return;
        }
        currentRadioStation++;
    }

    public void prev() {
        if (currentRadioStation == 0) {
            currentRadioStation = numberOfStations - 1;
            return;
        }
        currentRadioStation--;
    }

    public void setRadioStation(int radioStation) {
        if (radioStation >= 0 && radioStation <= (numberOfStations - 1)) {
            currentRadioStation = radioStation;
        }
    }

    public int getRadioStation() {
        return currentRadioStation;
    }

    public int getNumberOfStations() { return numberOfStations; }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }

    public int getVolume() {
        return currentVolume;
    }

    public void setVolume(int newVolume) {
        if (newVolume >=0 && newVolume <= 100) {
            currentVolume = newVolume;
        }
    }
}
