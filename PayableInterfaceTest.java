//Payable Interface Test
//CSC 221
//Professor: Dr. Chiu
//Student: Mohammed Hossain
//EmplID: 23239756

public class PayableInterfaceTest{

    public static void main(String[] args) {

        Payable[] payableObjects = new Payable[6];

        payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
        payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
        payableObjects[2] =
                new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        payableObjects[3] =
                new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
        payableObjects[4] =
                new CommissionEmployee( "Sue", "Jones", "333-33-3333", 10000, .06 );
        payableObjects[5] =
                new BasePlusCommissionEmployee( "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );

        System.out.println(
                "Invoices and Employees processed polymorphically:\n");

        for(Payable currentPayable : payableObjects){
            System.out.printf("%s \n%s: $%,.2f\n\n",
                    currentPayable.toString(),
                    "Payment due", currentPayable.getPaymentAmount());
        }

        for (Payable currentPayable : payableObjects){
            if(currentPayable instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee)currentPayable;
                double employeePay = employee.getBaseSalary();
                double newSalary = employeePay + (employeePay * .10);
                employee.setBaseSalary(newSalary);

                System.out.printf("The base pay of " + employee.getFirstName() + " " +
                                employee.getLastName() + " with a 10%% raise is %.2f\n",
                        newSalary);
            }

        }
    }
}