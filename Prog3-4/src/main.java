import Exc.CheckExt;
import components.ballColors;
import components.ballSizes;
import mainClasses.ChristopherRobin;
import mainClasses.RandomGuy;
import mainClasses.ball;
import mainClasses.character;

public class main {

    public interface Group {
        public String toString();
    }


    public static void main(String[] args) throws CheckExt {
        character Vinni = new character("Винни - Пух", "Большой", new ball(), new ball());
        character Patka = new character("Пятачок", "Кроха", new ball(ballColors.Синий, ballSizes.Большой));
        character Krolik = new character("Кролик", "Высокий", new ball(ballColors.Зеленый, ballSizes.Маленький), new ball(ballColors.Синий, ballSizes.Большой, true));
        character Oslik = new character("Иа");
        System.out.println("Герои наших любимых мультфильмов снова встретились!!!");
        Vinni.addOurCharacter();
        System.out.println(Vinni.Get() + " Укололся иголкой и");
        character.Cheek.Cheek("Раздулась", Vinni);
        Patka.addOurCharacter();
        Krolik.addOurCharacter();
        Oslik.addOurCharacter();
        System.out.println("Бедняге Иа не хватило шарика, который раздавали в центре леса! Вот тут остальные и думают с ним поделиться ");
        Vinni.present(Oslik);
        Patka.present(Oslik);
        Krolik.present(Oslik);
        System.out.println("Теперь у каждого персонажа есть следующие шарики: ");
        System.out.println(Vinni.Get() + " : " + Vinni.MyBall() + ", " + Vinni.MyGift());
        System.out.println(Patka.Get() + " : " + Patka.MyBall() + ", " + Patka.MyGift());
        System.out.println(Krolik.Get() + " : " + Krolik.MyBall() + ", " + Krolik.MyGift());
        System.out.println(Oslik.Get() + " : " + Oslik.MyBall() + " " + Oslik.MyGift());
        ChristopherRobin on = new ChristopherRobin();
        on.takeGun();
        Group group = new Group() {
            final character[] chr = {Vinni, Patka, Oslik, on, Krolik};

            @Override
            public String toString() {
                StringBuilder answer = new StringBuilder();
                for (character el : chr) {
                    answer.append(el.Get() + ", ");
                }
                return answer.toString();
            }
        };

        goToTrip(group, "Лес");
        RandomGuy guy = new RandomGuy("Cole");
        ChristopherRobin wrong = new ChristopherRobin();
        wrong.gun = new ChristopherRobin.Gun();
        wrong.gun.setName("пистолет");

    }

    public static void goToTrip(Group group, String place) {
        class PlaceToVisit {
            private String place;

            public PlaceToVisit(String place) {
                this.place = place;
            }

            public String getPlace() {
                return place;
            }

            public void setPlace(String place) {
                this.place = place;
            }
            public void doThis(){
                System.out.println(group.toString()+ "Отправились в "+ place);
            }
        }
        PlaceToVisit place1 = new PlaceToVisit(place);
        place1.doThis();
    }
}
