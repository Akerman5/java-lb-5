import  java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.io.IOException;


public class Main
{
    public static ArrayList<String> ReadStrFromFile(String fileName) throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            ArrayList<String> list= new ArrayList<String>();
            while (line !=null)
            {
                list.add(line);
                line = bufferedReader.readLine();
            }
            return list;
        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }
    static Scanner skr = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static void Завдання1A()throws IOException {
        File file = new File("Example.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        String source =    "\tЦе простий спосіб показати роботу програми <Подивіться на мене, я гарний метелик.   " +
                "\tПурхаю в місячному світлі> 50 ";

        System.out.println("\t//////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\t///Це простий спосіб показати роботу програми <Подивіться на мене, я гарний метелик.   ///");
        System.out.println("\t///                                                                                    ///");
        System.out.println("\t///Пурхаю в місячному світлі> 50                                                       ///");
        System.out.println("\t//////////////////////////////////////////////////////////////////////////////////////////");

        writer.write(source);
        writer.flush();
        writer.close();


        FileReader fr = new FileReader(file);
        char [] a = new char[200];
        fr.read(a);
        int digits = 0;
        for (String part : source.split(" \n "))
        {
            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) >= 48 && source.charAt(i) <= 57)
                    digits++;
            }
            System.out.println("\n****************************************************************************************\n");
            System.out.print(new StringBuilder(part).reverse().toString()+"\n");
            System.out.print(" \n");

        }
        System.out.println("\n##########################################################################################\n");
        System.out.println("\t\nКількість інтових елементів = " + digits);
    }
    public static void Завдання1B() throws IOException {


        String source;
        System.out.println("Введіть з клавіатур текст :");
        source= skr.nextLine();
        int digits = 0;
        for (String part : source.split(" "))
        {
            for (int i = 0; i < part.length(); i++) {
                if (part.charAt(i) >= 48 && part.charAt(i) <= 57)
                    digits++;
            }
            System.out.print(new StringBuilder(part).reverse().toString());
            System.out.println(" ");

        }
        System.out.println("##########################################################################################\n");
        System.out.println("\t\nКількість інтових елементів = " + digits);
    }
    public static void Завдання2() throws IOException {

        String key;
        try {

            ArrayList<String>  mass=  ReadStrFromFile("Example1.txt");

            System.out.println("Введіть слово :");
            key =skr.next();
            for (String line :mass)
            {

                if(line.contains(key))
                {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }

    public static void main(String[] args) {

        int ask = 0,ask1=0;

        Scanner skr = new Scanner(System.in);


        try {

            Exception ERROR = new Exception();
            System.out.println("1 - Інвертує рядок, подаючи його у зворотному вигляді, підраховує кількість чисел у тексті.");
            System.out.println("2 - Дано текстовий файл, і виводить на екран список тих речень  які містять задане слово.");

            while (ask != 3)
            {
                ask = skr.nextInt();
                switch (ask)
                {
                    case 1:
                    {
                        System.out.println("1- Ввід з клавіатури");
                        System.out.println("2- Готовий текст");
                        ask1=skr.nextInt();
                        switch (ask1)

                        {
                            case 1:{Завдання1B();}break;

                            case 2:{Завдання1A();}break;

                        }}break;

                    case 2:

                    {Завдання2();}break;

                    case 3:
                    {
                        System.out.println("Програма закрита");
                    }

                    default:
                        System.out.println(ANSI_RED + ("Введіть вірно завдання!"));
                }
            }
            throw ERROR ;

        } catch (Exception er)
        {
            System.out.println(er);
        }
    }

}