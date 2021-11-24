import java.util.Set;
import java.io.*;
import java.util.Scanner;

public class ATMjava {

    public static void main(String[] args) {
        atm();
    }

    public static void atm() {
        int StavNaUctu = 100000, vyber, vklad;
        int menuVyber = 0;
        int spatnepokusy = 0;
        final int pin = 1234;
        int zadanyPin;

        System.out.println("Zadejte pin");
        Scanner cti = new Scanner(System.in);
        zadanyPin = cti.nextInt();

        while (spatnepokusy <= 4) {
            if (pin == zadanyPin) {

                while (menuVyber != 4) {
                    System.out.println("1.Vyber");
                    System.out.println("2.Vklad");
                    System.out.println("3.Zobraz zustatek na ucte");
                    System.out.println("4.Exit");

                    System.out.println("Zadejte svuj vyber: ____");
                    menuVyber = cti.nextInt();

                    switch (menuVyber) {
                        case 1:
                            System.out.println("Zadejte kolik chcete vybrat: ____");
                            vyber = cti.nextInt();

                            if (StavNaUctu >= vyber) {
                                StavNaUctu = StavNaUctu - vyber;
                                System.out.println("Potrebuje te stvrzenku?: y/n");
                                String stvrenka = cti.nextLine();
                                if (stvrenka.equals("y")) {
                                    System.out.println("tisknu stvzenku");
                                    System.out.println("odeberte bankovky prosim");
                                }
                                if (stvrenka.equals("n")) {
                                    System.out.println("odeberte bankovky prosim");
                                    System.out.println("dekujeme za pouziti naseho bankomatu");
                                }
                            } else {
                                System.out.println("Nedostatecny zustatek na uctu");
                            }
                            break;
                        case 2:
                            System.out.println("Kolik penez chcete vlozit: ____");
                            vklad = cti.nextInt();

                            StavNaUctu = StavNaUctu + vklad;

                            System.out.println("Vas vklad byl uspesne proveden");
                            System.out.println("_____________");
                            System.out.println("tisknu stvzenku");
                            break;
                        case 3:
                            System.out.println("Vas zustatek na uctu je" + StavNaUctu);

                            break;
                        case 4:
                            System.out.println("Dekujeme za vyuziti bankomatu");
                            break;

                    }
                }
            } else {
                System.out.println("Spatne zadany pin");
                spatnepokusy++;
                System.out.println("Zbyva pokusu "+(4-spatnepokusy));
                System.out.println("Zkuste to znovu: ");
                zadanyPin=cti.nextInt();
                System.out.println(zadanyPin);
            }


        }
        System.out.println("NESPRAVNY PIN!!!");
        System.out.println("________________");
        System.out.println("BLOKUJI KARTU");
    }
}
