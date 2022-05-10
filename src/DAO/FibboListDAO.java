package DAO;

import FileRepository.FileRepo;
import FileRepository.FileRepoInterface;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibboListDAO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3341962368334380019L;
    private List<Long> fibboList = new ArrayList<>();
    public FibboListDAO(FileRepoInterface fileRepo) {
        if (fileRepo.read() != null) {
            fibboList = fileRepo.read().getFibboList();
        } else {
            fibboList.addAll(Arrays.asList(1L, 1L));
        }
    }

    public List<Long> getFibboList() {
        return fibboList;
    }

}
