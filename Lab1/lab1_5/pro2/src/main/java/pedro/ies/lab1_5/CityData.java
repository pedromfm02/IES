package pedro.ies.lab1_5;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityData {
    @SerializedName("idRegiao")
    @Expose
    private int idRegiao;
    @SerializedName("idAreaAviso")
    @Expose
    private String idAreaAviso;
    @SerializedName("idConcelho")
    @Expose
    private int idConcelho;
    @SerializedName("globalIdLocal")
    @Expose
    private int globalIdLocal;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("idDistrito")
    @Expose
    private int idDistrito;
    @SerializedName("local")
    @Expose
    private String local;
    @SerializedName("longitude")
    @Expose
    private double longitude;

    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getIdAreaAviso() {
        return idAreaAviso;
    }

    public void setIdAreaAviso(String idAreaAviso) {
        this.idAreaAviso = idAreaAviso;
    }

    public int getIdConcelho() {
        return idConcelho;
    }

    public void setIdConcelho(int idConcelho) {
        this.idConcelho = idConcelho;
    }

    public int getGlobalIdLocal() {
        return globalIdLocal;
    }

    public void setGlobalIdLocal(int globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
