import java.io.*;
import  java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path directory = Path.of("D:\\pract\\");
        Path file = Path.of("D:\\pract\\one.txt");
        Path file1 = Path.of("D:\\pract\\two.txt");
        Path file2 = Path.of("D:\\pract\\three.txt");
        Path file3 = Path.of("D:\\pract\\four.txt");
        try {
            if (Files.notExists(directory)) {
                Files.createDirectory(directory);
                System.out.println("Директорію створено: " + directory.toAbsolutePath());
            } else {
                System.out.println("Директорія вже існує: " + directory.toAbsolutePath());
            }
            if (Files.notExists(file)) {
                Files.createFile(file);
                System.out.println("Файл створено: " + file.toAbsolutePath());
            } else {
                System.out.println("Файл вже існує: " + file.toAbsolutePath());
            }
            if (Files.notExists(file1)) {
                Files.createFile(file1);
                System.out.println("Файл створено: " + file1.toAbsolutePath());
            } else {
                System.out.println("Файл вже існує: " + file1.toAbsolutePath());
            }
            if (Files.notExists(file2)) {
                Files.createFile(file2);
                System.out.println("Файл створено: " + file2.toAbsolutePath());
            } else {
                System.out.println("Файл вже існує: " + file2.toAbsolutePath());
            }
            if (Files.notExists(file3)) {
                Files.createFile(file3);
                System.out.println("Файл створено: " + file3.toAbsolutePath());
            } else {
                System.out.println("Файл вже існує: " + file3.toAbsolutePath());
            }
            writeInf(file,"Marta", 18,"f");
            writeInf(file,"Ivan", 17,"m");
            writeInf(file,"Petro", 18,"m");
            writeInf(file,"Julia", 19,"f");
            writeInf(file,"Katia", 17,"f");
            writeInf(file,"Andriy", 20,"m");
            writeText(file1, "blablabla" );
            writeText(file1, "blablabla" );
            writeText(file1, "blablabla" );
            writeText(file1, "blablabla" );
            writeText(file1, "blablabla" );
            writeText(file1, "blablabla" );
            writeText(file1, "blablabla" );
            int line = count(file1);
            System.out.println("Кількість рядків: "+ line);


            System.out.println("Напишіть шлях до файлу:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String v = reader.readLine();
            File v1 = new File(v);
            copy(file.toFile(),v1);






        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    public static void writeInf(Path file, String name,int age,String sex){
        String information= name+", "+age+","+sex;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile(),true))){
            writer.write(information);
            writer.newLine();
            System.out.println("Інформацію додано: "+ information);
        }catch(Exception e){
            System.out.println("Помилка: "+e.getMessage());
        }
    }
    public static void writeText(Path file, String text){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile(),true))){
            writer.write(text);
            writer.newLine();
            System.out.println("Текст додано: "+ text);
        }catch(Exception e){
            System.out.println("Помилка: "+e.getMessage());
        }
    }
    public static int count(Path file1){
        int count=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file1.toFile()))){
            while(reader.readLine()!=null){
                count++;
            }
        }catch(Exception e){
            System.out.println("Помилка: "+e.getMessage());
        }
        return count;
    }
    public static void copy(File fileOne,File fileTwo){
        try{
            FileInputStream f = new FileInputStream(fileOne);
            FileOutputStream f1=new FileOutputStream(fileTwo);
            int text;
            while((text=f.read())!=-1){
                f1.write(text);
            }
            f.close();
            f1.close();
        }catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}