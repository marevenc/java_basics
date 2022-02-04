import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final int COMPONENTS_NUMBER = 4;

        String[] components = data.split("\\s+");
        if(components.length != COMPONENTS_NUMBER){
            throw new IllegalArgumentException("Wrong format");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];

        Pattern patternPhone = Pattern.compile("(\\+7|8)?[-\\s(]*(\\d{3})[-)\\s]*(\\d{3})[-\\s]?(\\d{2})[-\\s]?(\\d{2})$");
        Pattern patternEmail = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        Matcher matcher = patternPhone.matcher(components[INDEX_PHONE]);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Wrong phone number format");
        }

        matcher = patternEmail.matcher(components[INDEX_EMAIL]);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Wrong email format");
        }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() throws EmptyCustomerListException {
        if (storage.isEmpty()){
            throw new EmptyCustomerListException("Customer list is empty");
        }
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if(!storage.containsKey(name)){
            throw new IllegalArgumentException("This customer doesn't exist");
        }
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}