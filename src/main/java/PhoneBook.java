import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
  private HashMap<String, List<Contact>> groups = new HashMap<>();

  public boolean addContactToGroup(String groupName, Contact contact) {
    return this.groups.get(groupName).add(contact);
  }

  public void addGroup(String groupName, List<Contact> contacts) {
    this.groups.put(groupName, contacts);
  }

  public HashMap<String, List<Contact>> getGroups() {
    return this.groups;
  }

  public Contact searchContactByPhone(String contactPhone) {
    Contact searchedContact = null;
    for (Map.Entry<String, List<Contact>> entry : groups.entrySet()) {
      for (Contact contact : entry.getValue()) {
        if (contact.phone.equals(contactPhone)) {
          System.out.println("Контакт " + contact + " в группе " + entry.getKey());
          searchedContact = contact;
        }
      }
    }
    return searchedContact;
  }

  public Contact searchContactInGroup(String groupName, Contact contact) {
    if (groups.get(groupName).contains(contact)) return contact;
    else {
      System.out.println("Контакта " + contact.toString() + " нет в телефонной книге в группе " + groupName);
      return null;
    }
  }
}
