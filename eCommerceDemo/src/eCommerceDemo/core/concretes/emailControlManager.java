package eCommerceDemo.core.concretes;

import eCommerceDemo.core.abstracts.ControlService;
import eCommerceDemo.entities.concretes.User;
import java.util.Random;
import java.util.Scanner;

public class emailControlManager implements ControlService{

	@Override
	public boolean control(User user) {
		Scanner scanner = new Scanner(System.in);
		char chosenValue ='h';
		System.out.println(user.getEmail()
				+ " adresine bir doğrulama kodu gönderdik. Hesabınızı doğrulamak istiyor musunuz? (E/H)");
		chosenValue = scanner.next().charAt(0);

		if (chosenValue == 'e' || chosenValue == 'E') {
			Random random = new Random();
			int randomInteger, enteredNumber, count = 0;

			do {
				randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

				System.out.println(
						"hesabınızı doğrulamak için mailinize gelen 6 haneli sayıyı giriniz:\n--> " + randomInteger);
				enteredNumber = scanner.nextInt();
				count++;
				if (count == 4) {
					System.out.println(
							"çok sayıda hatalı denemenizden dolayı hesabınızı şuanda doğrulayamıyoruz.\nLütfen daha sonra tekrar deneyiniz..");
					scanner.close();
					return false;
				}
			} while (!(enteredNumber == randomInteger) && count < 4);
			System.out.println("tebrikler! hesabınız doğrulandı. ");
			
			scanner.close();
			return true;

		}
		scanner.close();
		return false;
	}

}
