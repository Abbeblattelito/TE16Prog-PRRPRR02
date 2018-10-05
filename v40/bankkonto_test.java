import java.util.Scanner;

public class bankkonto_test {

	public static void main(String[] args) {

		System.out.println("V�lkomen till v�r bank!");
		System.out.println("Skriv in ditt namn och v�lj en fyrsiffrig kod");
		Scanner sc = new Scanner(System.in);

		String �gare = sc.nextLine();
		int kod = Integer.parseInt(sc.nextLine());

		Bankkonto konto = new Bankkonto(�gare, kod);

		boolean stop = false;
		while (!stop) {

			double saldo = konto.getSaldo();
			System.out.println("Du har just nu: " + saldo + "kr p� ditt konto.");
			System.out.println("Skriv 1 f�r att ta ut pengar");
			System.out.println("Skriv 2 f�r att s�tta in pengar");
			System.out.println("Skriv 3 f�r att sluta");
			int val = Integer.parseInt(sc.nextLine());

			if (val == 1) {
				System.out.print("Skriv in summa att ta ut: ");
				int summa = Integer.parseInt(sc.nextLine());
				System.out.print("Skriv in din kod: ");
				kod = Integer.parseInt(sc.nextLine());
				int status = konto.withdraw(summa, kod);
				if (status == 3) {
					System.out.println("FEL KOD");
				} else if (status == 2) {
					System.out.println("FEL SUMMA");
				} else if (status == 4) {
					System.out.println("DU HAR F�R LITE PENGAR");
				} else {
					System.out.println("DU TOG UT " + summa + "kr");
				}

			} else if (val == 2) {
				System.out.print("Skriv in summa att s�tta in: ");
				int summa = Integer.parseInt(sc.nextLine());
				int status = konto.deposit(summa);
				if (status == 2) {
					System.out.println("FEL SUMMA");
				} else {
					System.out.println("DU SATTE IN " + summa + "kr");
				}
			} else if (val == 3) {
				stop = true;
			}

			System.out.println();
		}

	}

}
