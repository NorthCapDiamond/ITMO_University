package data;

import java.io.IOException;

public class Coordinates {
    private Float x; //Максимальное значение поля: 955, Поле не может быть null
    private Long y; //Значение поля должно быть больше -293, Поле не может быть null


    public Coordinates(){}
    public Coordinates(Float x, Long y){
        this.x = x;
        this.y = y;

    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        try{
            if(x==null|| x>955){
                throw new IOException("Вы ввели более 955 или null");
            }
            else {
                this.x = x;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        try{
            if(y==null|| y<=-293){
                throw new IOException("Вы ввели менее -293 или null");
            }
            else {
                this.y = y;
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return String.format("x: %d\ny:%d",x,y);
    }
}