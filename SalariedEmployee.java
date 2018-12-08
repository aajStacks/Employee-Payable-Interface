public class SalariedEmployee extends Employee{

    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber,
                            double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        setWeeklySalary(weeklySalary);
    }


    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if(weeklySalary >= 0.0){
            this.weeklySalary = weeklySalary;
        }else{
            throw new IllegalArgumentException(
                    "Weekly salary must be >= 0.0");
        }
    }

    @Override
    public double getPaymentAmount(){
        return getWeeklySalary();
    }

    @Override
    public String toString(){
        return String.format("Salaried employee: %s\n%s: $%,.2f",
                super.toString(), "Weekly salary", getWeeklySalary());
    }
}