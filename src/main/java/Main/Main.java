/*chadwick Uresti
1064029
CIS3365 TH 530-7 SP19
 */

package Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private customerRepository customerRepository;

    @Autowired
    private addressRepository addressRepository;

    public static void main(String[] args){
        SpringApplication.run(Main.class);
    }
    @Override
    public void run(String... strings) throws Exception{
        customerRepository.deleteAll();
        addData();
        for(Customer customer: customerRepository.findAll()){
            System.out.println(customer);
        }
    }
    private void addData() {
        Address address = new Address();
        address.setStreetName("Anywhere Street");
        address.setStreetNumber("123");
        address.setState("Texas");
        address.setZipcode(77569);

        Address address2 = new Address();
        address2.setStreetName("nowhere Street");
        address2.setStreetNumber("424");
        address2.setState("Texas");
        address2.setZipcode(77569);

        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        addresses.add(address2);

        Customer customer = new Customer("uresti", "Chadwick");
        customer.setAddresses(addresses);
        customerRepository.save(customer);
    }
}

