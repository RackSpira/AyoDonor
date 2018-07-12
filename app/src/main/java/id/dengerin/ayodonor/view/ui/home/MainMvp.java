package id.dengerin.ayodonor.view.ui.home;

import java.util.List;

import id.dengerin.ayodonor.model.Gol;

/**
 * Created by joedhaalzelvin on 12/07/18.
 */

public interface MainMvp {
    void showLoading();

    void removeLoading();

    void showGolDar(List<Gol> golList);

    void showError(String error);
}
