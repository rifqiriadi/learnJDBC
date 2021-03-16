package service;

import model.Rest;
import model.RestResult;

import java.util.List;

public interface RestService {
    List<RestResult> getAll();
    RestResult getRestById(int id);
    void addRest(Rest rest);
    void updateRest(Rest rest, int id);
    void deleteRestById(int id);int lastestInput();
}
