package Service;

import DAO.FibboListDAO;
import FileRepository.FileRepo;

import java.util.stream.Collectors;

public class FibbonachiGenerator {

    private FibboListDAO fibboListDAO = new FibboListDAO();
    private long num1 = fibboListDAO.getFibboList().get(fibboListDAO.getFibboList().size()-2);
    private long num2 = fibboListDAO.getFibboList().get(fibboListDAO.getFibboList().size()-1);

    public void createFibboList(int indexInFibboList){
        if (fibboListDAO.getFibboList().size()>=indexInFibboList
            && FileRepo.readFromFile() != null){
            indexIsPresentInBase(indexInFibboList);
        }
        else {
            fibboRecursionGenerator(indexInFibboList);
            FileRepo.writeToFile(fibboListDAO);
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

    private void indexIsPresentInBase (int indexInFibboList){
        System.out.println("Index is already present in file.");
        System.out.println("Shorten version of FIBBO-LIST:");
        System.out.println(
                fibboListDAO.getFibboList()
                .stream()
                .limit(indexInFibboList)
                .collect(Collectors.toList()));
    }
}
