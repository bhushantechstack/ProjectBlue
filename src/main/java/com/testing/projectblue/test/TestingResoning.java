package com.testing.projectblue.test;

public class TestingResoning {
    public static void main(String []args)
    {
        // for loop practice

        for(int i=0; i<=100; i++)
        {
            System.out.print(i+" ");
        }
        int x= 0,count=0;

        while(10>x)
        {
            count++;
            x++;
            System.out.println(count);
        }
        int y =15;
        do{
            y--;
            System.out.println("The Great Indian Kapil Sharma Show");
        }
        while(10<y);


        // print multiple of two 2,4,6,8...100

        for(int i=2;i<=100;i++)
        {
            System.out.print(i+" ");
            i++;

        }

        // write a program to print like this
        //2*1=2
        //2*2=4.....2*10= 20

        for(int i=1; i<=10;i++)
        {
            int j= i*2;
            System.out.println("2*"+i+"="+j);
        }

        // multiple of 4 (1 to 120)

        for(int i=1;i<=120;i++)
        {
            if(i%4==0)
            {
                System.out.print(i+" ");
            }
        }

        // calculate even number from 1 to 120 and also get count
        int co=0;
        for(int i=1; i<=120;i++)
        {
            if(i%2==0)
            {
                System.out.println(i+" ");
                co++;
            }
        }
        System.out.println("total count is "+co);

        // print some of 1 to 10
        int sum=0;
        for(int i=1; i<=10;i++)
        {
            sum= sum+i;
            
        }
        System.out.println(sum);

        // print multiplication of 1 to 10
        int mul=1;
        for(int i=1; i<=10; i++)
        {
            mul=mul*i;
        }
        System.out.println(mul);

        // find perfect number eg 6
        int per=0, perNO=6;
        for(int i=1;i<6;i++)
        {
            if(6%i==0)
            {
                per =per+i;
            }
        }
        if(perNO == per)
        {
            System.out.println("This is perfect number");
        }


        // factors of 9  like 1,3,9

        for(int i=1; i<=9;i++)
        {
            if(9%i==0)
            {
                System.out.println(i+" ");
            }
        }

        // print series as 2, 4, 16,256, 65536
        int n=2;
        for(int i=1;i<=5;i++)
        {
            System.out.println(n+" ");
            n = n*n;
        }

        // print number of digit in 4323

        int no= 4323;
        int rem=0;
        int cou=0;
        while(no>0)
        {
            rem= no%10;
            cou++;
            no=no/10;
        }
        System.out.println(cou);
        System.out.println("-------");

        // reverse given number 492
        int number=492, reminder =0;
        while(number>0)
        {
            reminder= number%10;
            number=number/10;
            System.out.println(reminder+" ");
        }

        
    }

}
