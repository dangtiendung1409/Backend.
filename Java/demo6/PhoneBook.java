package demo6;

import java.util.ArrayList;


public class PhoneBook extends Phone {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }



    ArrayList<PhoneNumber> phoneList = new ArrayList<>();

    @Override
    public void insertPhone(String name, String phone) {
        boolean found = false;
        for (PhoneNumber p : phoneList) {
            if (p.getName().equals(name)) {
                p.getPhone().add(phone);
                found = true;
                break;
            }
        }
        if (!found) {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneList.add(new PhoneNumber(name, phones));
        }
    }

    @Override
    public void removePhone(String name) {
        phoneList.removeIf(p -> p.getName().equals(name));
    }

    @Override
    public void updatePhone(String name, String oldPhone, String newPhone) {
        for (PhoneNumber p : phoneList) {
            if (p.getName().equals(name)) {
                ArrayList<String> phones = p.getPhone();
                for (int i = 0; i < phones.size(); i++) {
                    if (phones.get(i).equals(oldPhone)) {
                        phones.set(i, newPhone);
                        break;
                    }
                }
                p.setPhone(phones);
                break;
            }
        }
    }


    @Override
    public PhoneNumber searchPhone(String name) {
        for (PhoneNumber p : phoneList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void sort() {
        phoneList.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }
    public void display() {
        for (PhoneNumber p : phoneList) {
            System.out.println(p.getName() + ": " + p.getPhone());
        }
    }

}