package demo2;

import java.util.Scanner;
public class BaiTap1 {
    public static void main (String[] args){
        //khai báo biến a là số cần kiểm tra, sum là tổng các ước số của a
        Scanner sc = new Scanner(System.in);
        int sum = 0, a;
        System.out.println("Nhập vào số cần kiểm tra: ");
        a = sc.nextInt();
        for(int i=1; i<=a/2; i++){
            if(a%i==0){
                //tổng các ước của a
                sum+=i;
            }
        }
        if(sum==a){
            System.out.println(a + "là số hoàn hảo");
        }else{
            System.out.println(a + "không phải là số hoàn hảo");
        }
    }
}