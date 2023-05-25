package demo2;

import java.util.Scanner;
public class BaiTap3 {
    public static void main(String[] args){
        int firstName, secondName, temp1, temp2, uscln, bscnn;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất: ");
        firstName = sc.nextInt();
        System.out.println("Nhập số thứ hai: ");
        secondName = sc.nextInt();
        //Tìm ước chung lớn nhất
        temp1 = firstName;
        temp2 = secondName;
        while (temp1!=temp2){
            if(temp1>temp2){
                temp1-=temp2;
            }else{
                temp2-=temp1;
            }
        }
        uscln=temp1;
        System.out.println("Ước số chung lớn nhất của" + firstName + "và" + secondName + "=" + uscln);
        System.out.println("Bội số chung nhỏ nhất của" + firstName + "và" + secondName + "=" + ((firstName*secondName) / uscln));
    }
}