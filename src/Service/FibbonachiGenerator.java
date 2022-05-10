package Service;

import DAO.FibboListDAO;
import FileRepository.FileRepo;
import FileRepository.FileRepoInterface;

import java.util.stream.Collectors;

public class FibbonachiGenerator {

    private final FileRepoInterface filerepo = new FileRepo();
    private final FibboListDAO fibboListDAO = new FibboListDAO(filerepo);
    private long num1 = fibboListDAO.getFibboList().get(fibboListDAO.getFibboList().size() - 2);
    private long num2 = fibboListDAO.getFibboList().get(fibboListDAO.getFibboList().size() - 1);

    public void createFibboList(int indexInFibboList) {
        if (fibboListDAO.getFibboList().size() >= indexInFibboList
                && filerepo.read() != null) {
            indexIsPresentInBase(indexInFibboList);
        } else {
            fibboRecursionGenerator(indexInFibboList);
            filerepo.write(fibboListDAO);
            System.out.println("File \"List.bin\" updated successfully");
            System.out.println("Your FIBBO-LIST:");
            System.out.println(fibboListDAO.getFibboList()
                    .stream()
                    .limit(indexInFibboList)
                    .collect(Collectors.toList()));
        }
    }

    private void fibboRecursionGenerator(int indexInFibboList) {
        while (fibboListDAO.getFibboList().size() < indexInFibboList) {
            long num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            fibboListDAO.getFibboList().add(num3);
            fibboRecursionGenerator(indexInFibboList);
        }
    }

    private void indexIsPresentInBase(int indexInFibboList) {
        System.out.println("Index is already present in file.");
        System.out.println("Shorten version of FIBBO-LIST:");
        System.out.println(
                fibboListDAO.getFibboList()
                        .stream()
                        .limit(indexInFibboList)
                        .collect(Collectors.toList()));
    }
}
