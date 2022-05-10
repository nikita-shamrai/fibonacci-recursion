package FileRepository;

import DAO.FibboListDAO;

public interface FileRepoInterface {
    void write (FibboListDAO list);
    FibboListDAO read();
}
