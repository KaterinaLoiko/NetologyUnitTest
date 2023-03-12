public class Contact {

  String name;
  String phone;

  Contact(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  @Override
  public int hashCode() {
    return phone.hashCode();
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) return false;
    if (!(object instanceof Contact)) return false;
    Contact objStudent = (Contact) object;
    return phone.equals(objStudent.phone);
  }

  @Override
  public String toString() {
    return name + " " + phone;
  }
}
