
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PhoneBookTest {

  private static final String GROUP_NAME = "Семья";
  PhoneBook phoneBook;
  Contact contact;
  List<Contact> contactList;

  @BeforeEach
  public void beforeEach() {
    phoneBook = new PhoneBook();
    contact = new Contact("Дочь", "86746756453");
    contactList = new ArrayList<>();
  }

  @Test
  public void addGroupTest(){
    phoneBook.addGroup(GROUP_NAME, contactList);

    Assertions.assertTrue(phoneBook.getGroups().containsKey(GROUP_NAME), "В телефонной книге нет такой группы");
  }

  @Test
  public void addContactToGroupFirstTest(){
    phoneBook.addGroup(GROUP_NAME, contactList);
    phoneBook.addContactToGroup(GROUP_NAME, contact);

    Assertions.assertEquals(contact, phoneBook.getGroups().get(GROUP_NAME).get(0),"В телефонной книге нет такого контакта");
  }

  @Test
  public void addContactToUnExistedGroupTest(){
    Class<NullPointerException> expected = NullPointerException.class;

    Executable executable = () -> phoneBook.addContactToGroup(GROUP_NAME, contact);

    Assertions.assertThrows(expected, executable, "В телефонной книге есть такая группа");
  }

  @ParameterizedTest
  @MethodSource("TestData#contacts")
  public void searchContactByPhoneTest(Contact contact, String phone){
    phoneBook.addGroup(GROUP_NAME, contactList);
    phoneBook.addContactToGroup(GROUP_NAME, contact);

    Contact searchedContact = phoneBook.searchContactByPhone(phone);

    Assertions.assertEquals(contact, searchedContact, "В телефонной книге нет контакта c таким телефоном");
  }

  @ParameterizedTest
  @MethodSource("TestData#contactsInGroup")
  public void searchContactInGroupTest(Contact contact, String groupName){
    phoneBook.addGroup(groupName, contactList);
    phoneBook.addContactToGroup(groupName, contact);

    Contact searchedContact = phoneBook.searchContactInGroup(groupName, contact);

    assertThat(searchedContact, equalTo(contact));
  }

  @Test
  public void addContactToGroupTest(){
    Contact husband = new Contact("Муж", "86746750453");
    contactList.add(contact);
    contactList.add(husband);
    phoneBook.addGroup(GROUP_NAME, contactList);

    assertThat(phoneBook.getGroups().get(GROUP_NAME), hasItems(contact, husband));
  }
}
