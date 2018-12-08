public class Invoice implements Payable{

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String part, String description, int count,
                   double price){
        partNumber = part;
        partDescription = description;
        setQuantity(count);
        setPricePerItem(price);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity >= 0){
            this.quantity = quantity;
        }else{
            throw new IllegalArgumentException("Quantity must be >=0");
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }
    public void setPricePerItem(double pricePerItem) {
        if(pricePerItem >= 0){
            this.pricePerItem = pricePerItem;
        }else{
            throw new IllegalArgumentException(
                    "Price per item must be >=0");
        }
    }


    @Override
    public String toString(){
        return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
                "Invoice", "Part number", getPartNumber(), getPartDescription(),
                "Quantity", getQuantity(), "Price per item", getPricePerItem());
    }

    @Override
    public double getPaymentAmount(){
        return getQuantity()*getPricePerItem();
    }
}