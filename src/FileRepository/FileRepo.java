package FileRepository;

import DAO.FibboListDAO;

import java.io.*;

public class FileRepo {

    public static void writeToFile (FibboListDAO list){
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream("List.bin"))){
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FibboListDAO readFromFile (){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("List.bin"))){
            return (FibboListDAO) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
