import com.enums.Inputs;
import com.models.Bank;
import com.models.BankRegistry;
import com.services.LoanServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankRegistry.addBank("IDIDI");
        BankRegistry.addBank("MBI");
        BankRegistry.addBank("UON");

        Scanner scanner = new Scanner(System.in);
        LoanServiceImpl service = new LoanServiceImpl();
        while(true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;

            try {
                String[] inputs = input.split(" ");

                if (inputs[0].equals(Inputs.LOAN.name())) {
                    service.allocateLoan(inputs[1], inputs[2], Double.parseDouble(inputs[3]), Double.parseDouble(inputs[4]), Double.parseDouble(inputs[5]));
                } else if (inputs[0].equals(Inputs.PAYMENT.name())) {
                    service.makePayment(inputs[1], inputs[2], Double.parseDouble(inputs[3]), Integer.parseInt(inputs[4]));
                } else if (inputs[0].equals(Inputs.BALANCE.name())) {
                    System.out.println(service.getBalance(inputs[1], inputs[2], Integer.parseInt(inputs[3])));
                }
            } catch (Exception e) {
                System.out.println("Input parsing exception " + e);
            }
        }
    }
}