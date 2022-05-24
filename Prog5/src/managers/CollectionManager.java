package managers;

import data.MusicBand;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionManager {
    private LinkedList<MusicBand> musicBands;
    private final Date creationDate = new Date();
    private Date upTheDate;

    public  CollectionManager(){
        musicBands = new LinkedList<MusicBand>();
    }

    public CollectionManager(LinkedList<MusicBand> data){
        this.musicBands = data;
    }

    public void add(MusicBand band){
        musicBands.add(band);
    }

    public LinkedList<MusicBand> getMusicBands() {
        return musicBands;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getUpTheDate() {
        return upTheDate;
    }

    public void setUpTheDate(Date upTheDate) {
        this.upTheDate = upTheDate;
    }
    public void removeAllElements() {
        musicBands.clear();
    }
    public MusicBand getHead() {
        return musicBands.getFirst();
    }
    public int length() {
        try {
            return musicBands.size();
        }catch (NullPointerException e){
            return 0;
        }
    }
    public void removeById(int id){
        for(MusicBand band: musicBands){
            if (band.getId()==id){
                musicBands.remove(band);
            }
        }
    }
    public MusicBand findById(int id){
        for(MusicBand band: musicBands){
            if(band.getId()==id) return band;
        }
        return null;
    }

    public void replace(int id, MusicBand band) {
        musicBands.set(id, band);
    }

    public MusicBand findByName(String prefix) {
        for (MusicBand band : musicBands) {
            if (band.getName().startsWith(prefix)) {
                return band;
            }
        }
        return null;
    }
    @Override
    public String toString(){
        String answer = "";
        int i = 1;
        answer+=("Вывод элементов коллекции...\n");
        for (MusicBand band : musicBands) {
            answer+=(String.format("Элемент номер %d",i)+"\n");
            i+=1;
            answer+=band.toString()+"\n";
        }
        return answer;
    }
}
