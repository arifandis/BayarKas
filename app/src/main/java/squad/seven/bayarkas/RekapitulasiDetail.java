package squad.seven.bayarkas;

/**
 * Created by afridha on 05/05/18.
 */

public class RekapitulasiDetail {
    String nama, nominal;

    public RekapitulasiDetail(String nama, String nominal) {
        this.nama = nama;
        this.nominal = nominal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
}
