package id.dengerin.ayodonor.view.ui.jadwal;

import java.util.List;

import id.dengerin.ayodonor.model.Gol;
import id.dengerin.ayodonor.model.Jadwal;
import id.dengerin.ayodonor.model.Provinsi;

/**
 * Created by joedhaalzelvin on 12/07/18.
 */

public interface JadwalMvp {
    void showLoading();

    void removeLoading();

    void showProvinsi(List<Provinsi> provinsiList);

    void showJadwalDonor(List<Jadwal> jadwalList);

    void showError(String error);
}
