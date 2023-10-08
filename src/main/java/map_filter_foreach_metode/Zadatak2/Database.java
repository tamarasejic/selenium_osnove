package map_filter_foreach_metode.Zadatak2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Database {
    private ArrayList<Customer> customers;

    public Database() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void removeCustomer(int id){
        ArrayList<Customer> removed = this.customers.stream()
                .filter(customer -> customer.getId() == id)
                .collect(Collectors
                        .toCollection(ArrayList::new));
        this.customers.removeAll(removed);
    }

    public ArrayList<String> getAllCustomerIDs(){
        return this.customers.stream()
                .map(Customer::getId)
                .map(String::valueOf)
                .collect(Collectors
                        .toCollection(ArrayList::new));
    }

    public ArrayList<CreditCard> getAllCustomerCreditCards(){
        return this.customers.stream()
                .map(Customer::getCard)
                .collect(Collectors
                        .toCollection(ArrayList::new));
    }

    public ArrayList<CreditCard> getAllUpToDateCards(int month) {
        return this.customers.stream()
                .map(Customer::getCard)
                .filter(card -> card.getMonth() < month)
                .collect(Collectors
                        .toCollection(ArrayList::new));

    }

    public String getCustomerCardCVC(int id) {
        return this.customers.stream()
                .filter(customer -> customer.getId() == id)
                .map(Customer::getCard)
                .map(CreditCard::getCvc)
                .toList()
                .toString();
    }


    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
