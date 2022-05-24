package data;

import java.io.IOException;

public class Album {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long tracks; //Значение поля должно быть больше 0
    private Integer length; //Поле не может быть null, Значение поля должно быть больше 0
    private long sales; //Значение поля должно быть больше 0

    public Album(){
    }
    public Album(String name, long tracks, Integer length, long sales){
        this.name=name;
        this.tracks=tracks;
        this.length=length;
        this.sales=sales;
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

    public long getTracks() {
        return tracks;
    }

    public void setTracks(long tracks) {
        try {
            if (tracks<=0){
                throw new IOException("tracks должны быть больше 0");
            }
            else{
                this.tracks=tracks;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        try {
            if (length==null || length<=0){
                throw new IOException("Вы передали Null в length");
            }
            else {
                this.length=length;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public long getSales() {
        return sales;
    }

    public void setSales(long sales) {
        try {
            if (sales<=0){
                throw new IOException("sales должны быть больше 0");
            }
            else{
                this.sales=sales;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return String.format("Название альбома: %s \nКоличество треков в альбоме: %d\nПродолжительность альбома: %d\nПродажи альбома: %d ",name,tracks,length,sales);
    }
}