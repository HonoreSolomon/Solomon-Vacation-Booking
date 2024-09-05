package com.solomon.vacation_booking.bootstrap;

import com.solomon.vacation_booking.dao.CustomerRepository;
import com.solomon.vacation_booking.dao.DivisionRepository;
import com.solomon.vacation_booking.entities.Customer;
import com.solomon.vacation_booking.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 1) {
        loadData();

        }
    }

    private void loadData() {


         Division division1 = divisionRepository.findById(2L).orElse(null);
        Division division2 = divisionRepository.findById(3L).orElse(null);
        Division division3 = divisionRepository.findById(4L).orElse(null);
        Division division4 = divisionRepository.findById(5L).orElse(null);
        Division division5 = divisionRepository.findById(6L).orElse(null);







        Customer customer1 = new Customer("Alice","Johnson","245 place", "99325", "(808)334-3434",division1);
        Customer customer2 = new Customer("Billy","Bob","111 St", "22101", "(720)462-4463",division2);
        Customer customer3 = new Customer("Tim","White","1919 Park", "14821", "(126)732-2213",division3);
        Customer customer4 = new Customer("Brit","Sharp","12 Start St", "19028", "(910)341-0342",division4);
        Customer customer5 = new Customer("Clark","Williams","1901 Pine Place", "69302", "(319)412-1721",division5);

//        division1.addCustomer(customer1);
//        division2.addCustomer(customer2);
//        division3.addCustomer(customer3);
//        division4.addCustomer(customer4);
//        division5.addCustomer(customer5);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

//        System.out.println("Customers Saved: " + customerRepository.findAll() );

    }



}
