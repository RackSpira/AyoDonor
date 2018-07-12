package id.dengerin.ayodonor.view.ui.stokdarah;

import java.util.List;

import id.dengerin.ayodonor.model.Gol;
import id.dengerin.ayodonor.model.Produk;
import id.dengerin.ayodonor.model.Provinsi;
import id.dengerin.ayodonor.model.Stok;

/**
 * Created by joedhaalzelvin on 12/07/18.
 */

public interface StokDarahMvp {
    void showLoading();

    void removeLoading();

    void showProduk(List<Produk> produkList);

    void showProvinsi(List<Provinsi> provinsiList);

    void showStokDarah(List<Stok> stokList);

    void showError(String error);
}
