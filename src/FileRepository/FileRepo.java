package FileRepository;

import DAO.FibboListDAO;

import java.io.*;

public class FileRepo implements FileRepoInterface, Serializable {

    @Serial
    private static final long serialVersionUID = 8663169602499357879L;

    @Override
    public void write(FibboListDAO list) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream("List.bin"))) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public FibboListDAO read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("List.bin"))) {
            return (FibboListDAO) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

}
