package mainClasses;

import components.ICharacter2;
import components.ballColors;
import components.ballSizes;
import components.iCharacter;

public class character implements iCharacter, ICharacter2  {
    public boolean canGet;
    public boolean canGift;
    String name;
    String size;
    ball Ball;
    ball Gift;

    public static class Cheek {
        private String condition;

        public static void Cheek(String condition, character p) {
            System.out.println("Щекa " + p.name + " Начала " + condition);
            return;

        }
    }

    public character() {
        this.name = "Добрый Дима";
        this.size = "185 sm";
        this.Ball = new ball(ballColors.Синий, ballSizes.Большой);
        this.Gift = new ball(ballColors.Зеленый, ballSizes.Большущий, true);
    }


    public character(String name) {

        this.name = name;
        this.size = "Средний";
        this.Ball = null;


        if (this.Ball == null) {
            canGet = true;
        } else {
            canGet = false;
        }
        if (this.Gift != null && Gift.isGift()) {
            canGift = true;
        } else {
            canGift = false;
        }

    }

    public character(String name, String size) {

        this.name = name;
        this.size = size;
        this.Ball = null;
        this.Gift = null;


        if (this.Ball == null) {
            canGet = true;
        } else {
            canGet = false;
        }
        if (this.Gift != null && Gift.isGift()) {
            canGift = true;
        } else {
            canGift = false;
        }

    }

    public character(String name, String size, ball Ball) {

        this.name = name;
        this.size = size;
        this.Ball = Ball;
        this.Gift = null;


        if (this.Ball == null) {
            canGet = true;
        } else {
            canGet = false;
        }
        if (this.Gift != null && Gift.isGift()) {
            canGift = true;
        } else {
            canGift = false;
        }

    }

    public character(String name, String size, ball Ball, ball Gift) {

        this.name = name;
        this.size = size;
        this.Ball = Ball;
        this.Gift = Gift;


        if (this.Ball == null) {
            canGet = true;
        } else {
            canGet = false;
        }
        if (this.Gift != null && Gift.isGift()) {
            canGift = true;
        } else {
            canGift = false;
        }

    }


    public void addOurCharacter() {
        System.out.println("Персонаж " + name + " появляется в нашей истории");
    }


    public void present(character c1) {
        if (this.Gift == null || this.Ball == null) {
            System.out.println("Эх, " + this.name + " и хотел бы, но у него нет лишнего!");
        }
        if ((this.Gift != null && this.Ball != null) && c1.Ball == null && Gift.isGift()) {
            c1.Ball = this.Gift;
            this.Gift = null;
            System.out.println("Щедрый " + this.name + " Дарит " + c1.Ball.bcolor + " " + c1.Ball.bsize + " Шарик " + c1.name);
        }
        if (this.Gift != null && c1.Ball == null && this.Ball != null && !Gift.isGift()) {
            System.out.println(this.name + " Жадина!!! У него 2 шарика, но он не готов поделиться с другом...");
        }
    }

    public String MyBall() {
        if (Ball != null) {
            return Ball.Get();
        } else {
            return "";
        }
    }

    public String MyGift() {
        if (Gift != null) {
            return Gift.Get();
        } else {
            return "";
        }
    }

    @Override
    public String Get() {
        if (this.name != null) {
            return name;
        } else {
            return "";
        }
    }

    @Override
    public boolean getGift() {
        return canGet;
    }

    @Override
    public boolean makeGift() {
        return canGift;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return false;
        }
    }
}