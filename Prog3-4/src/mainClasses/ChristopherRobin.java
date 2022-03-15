package mainClasses;

import Exc.CheckExt;

public class ChristopherRobin extends character {
    private String name = "Christopher Robin";

    public ChristopherRobin() {
    }

    public Gun gun;

    public void Shoot() {
        System.out.println("It's working");
    }

    public void takeGun() {
        this.gun = new Gun();
        System.out.println("Christopher Robin берет " + this.gun.getName());
    }

    public static class Gun {
        String Gunname;

        public Gun() {
            this.Gunname = "Gun";
        }

        public void setName(String name) throws CheckExt {
            switch (name) {
                case "AAA":
                case "Ружье":
                case "Bottas":
                case "Russian bullet":
                    Gunname = name;
                    break;
                default:
                    throw new CheckExt(name);
            }

        }

        public Gun(String name) {
            this.Gunname = name;
        }

        public String getName() {
            return this.Gunname;
        }

    }
}
