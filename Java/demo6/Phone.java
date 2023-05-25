package demo6;

public abstract class Phone {
    abstract void insertPhone(String name, String phone);

    abstract void removePhone(String name);

    abstract void updatePhone(String name,String oldphone, String newphone);

    abstract PhoneNumber searchPhone(String name);

    abstract void sort();
}
