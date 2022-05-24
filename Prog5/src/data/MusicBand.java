package data;

import com.sun.istack.internal.NotNull;
import util.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

@XmlType(name = "MusicBand")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBand implements Comparable<MusicBand>{
    @XmlElement(name = "id", required=true)
    @NotNull
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NotNull
    @XmlElement(name = "name", required=true)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    @XmlElement(name = "coordinates", required=true)
    private Coordinates coordinates; //Поле не может быть null
    @NotNull
    @XmlElement(name = "creationDate", required=true)
    @XmlJavaTypeAdapter(util.DateAdapter.class)
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @NotNull
    @XmlElement(name = "numberOfParticipants", required=true)
    private int numberOfParticipants; //Значение поля должно быть больше 0
    @NotNull
    @XmlElement(name = "albumsCount", required=true)
    private Integer albumsCount; //Поле не может быть null, Значение поля должно быть больше 0
    @NotNull
    @XmlElement(name = "genre", required=true)
    private MusicGenre genre; //Поле не может быть null
    @NotNull
    @XmlElement(name = "bestAlbum", required=true)
    private Album bestAlbum; //Поле может быть null

    public MusicBand(){}

    public MusicBand(int id, String name, Coordinates coordinates, LocalDate creationDate, int numberOfParticipants, Integer albumsCount, MusicGenre genre, Album bestAlbum){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.albumsCount = albumsCount;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        try {
            if(id<0){
                throw new IOException("Ваш ID меньше 0");
            }
            else {
                this.id = id;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            if (name==null||name.isEmpty()){
                throw new IOException("Вы передали Null в название");
            }
            else {
                this.name=name;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        try {
            if (coordinates==null){
                throw new IOException("Вы передали Null в coordinates");
            }
            else {
                this.coordinates=coordinates;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        try {
            if (creationDate==null){
                throw new IOException("Вы передали Null в creationDate");
            }
            else {
                this.creationDate=creationDate;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        try {
            if (numberOfParticipants<=0){
                throw new IOException("numberOfParticipants должно быть больше 0");
            }
            else{
                this.numberOfParticipants=numberOfParticipants;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public Integer getAlbumsCount() {
        return albumsCount;
    }

    public void setAlbumsCount(Integer albumsCount) {
        try {
            if (albumsCount<=0){
                throw new IOException("albumsCount должно быть больше 0");
            }
            else{
                this.albumsCount=albumsCount;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        try {
            if (genre==null){
                throw new IOException("Вы передали Null в genre");
            }
            else {
                this.genre=genre;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public Album getBestAlbum() {
        return bestAlbum;
    }

    public void setBestAlbum(Album bestAlbum) {
        try {
            if (bestAlbum==null){
                throw new IOException("Вы передали Null в bestAlbum");
            }
            else {
                this.bestAlbum=bestAlbum;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    @Override
    public String toString(){
        String answer ="";
        answer+= String.format("ID : %d\n",id);
        answer+= String.format("Название группы : "+name+"\n");
        answer+= String.format("Количество участников : %d\n",numberOfParticipants);
        answer+= String.format("Количество альбомов : %d\n",albumsCount);
        answer+= String.format("Лучший альбом :\n"+bestAlbum.toString()+"\n");
        answer+= String.format("Дата создания группы : "+creationDate.toString()+"\n");
        answer+= String.format("Жанр : "+genre.toString()+"\n");
        return answer;
    }

    @Override
    public int compareTo(MusicBand o) {
       return (int) (this.bestAlbum.getSales()-o.bestAlbum.getSales());
    }
}