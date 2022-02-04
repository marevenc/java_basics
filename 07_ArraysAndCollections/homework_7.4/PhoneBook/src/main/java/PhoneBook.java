import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        Pattern patternName = Pattern.compile("[A-Za-zА-Яа-я]+");
        Pattern patternPhone  = Pattern.compile("\\d+");
        Matcher matcherName = patternName.matcher(name);
        Matcher matcherPhone = patternPhone.matcher(phone);

        if(matcherPhone.find() && matcherName.find() && !phoneBook.containsValue(name)){
            phoneBook.put(phone, name);
        }
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getNameByPhone(String phone) {
        String name = "";

        if(phoneBook.containsKey(phone)){
            name = phoneBook.get(phone);
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return name + " - " + phone;
    }

    public Set<String> getPhonesByName(String name) {
        Set<String> contact = new TreeSet<>();
        if(phoneBook.containsValue(name)){
            for(Map.Entry<String, String> entry : phoneBook.entrySet()){
                if(Objects.equals(name, entry.getValue()))
                    contact.add(name + " - " + entry.getKey());
            }
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        return contact;
    }

    public Set<String> getAllContacts() {
        Set<String> contacts = new TreeSet<>();
        for(Map.Entry<String, String> entry : phoneBook.entrySet()){
            contacts.add(entry.getValue() + " - " + entry.getKey());
        }
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        return contacts;
    }

    public boolean containsName(String name){
        return phoneBook.containsValue(name);
    }

    public boolean containsPhone(String phone){
        return phoneBook.containsKey(phone);
    }

}