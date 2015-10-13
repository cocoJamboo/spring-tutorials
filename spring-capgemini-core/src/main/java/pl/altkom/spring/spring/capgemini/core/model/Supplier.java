package pl.altkom.spring.spring.capgemini.core.model;

/**
 *
 * @author kursant7
 */
public class Supplier {

    private Long id;

    private String name;

    private Address address;

    private String vatIdentificationNumber;

    /**
     * Number of days to pay invoice.
     */
    private int paymentDeadline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getVatIdentificationNumber() {
        return vatIdentificationNumber;
    }

    public void setVatIdentificationNumber(String vatIdentificationNumber) {
        this.vatIdentificationNumber = vatIdentificationNumber;
    }

    public int getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(int paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

}
