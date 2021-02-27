
package beans;


public class Clientes {
    private String tarjetaCli;
    private String nombreCli;
    private double credtitoCli;
    private String claveClie;
    private String correoCli;

    public Clientes() {
    }

    public Clientes(String tarjetaCli, String nombreCli, double credtitoCli, String claveClie, String correoCli) {
        this.tarjetaCli = tarjetaCli;
        this.nombreCli = nombreCli;
        this.credtitoCli = credtitoCli;
        this.claveClie = claveClie;
        this.correoCli = correoCli;
    }
    
    

    public String getTarjetaCli() {
        return tarjetaCli;
    }

    public void setTarjetaCli(String tarjetaCli) {
        this.tarjetaCli = tarjetaCli;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public double getCredtitoCli() {
        return credtitoCli;
    }

    public void setCredtitoCli(double credtitoCli) {
        this.credtitoCli = credtitoCli;
    }

    public String getClaveClie() {
        return claveClie;
    }

    public void setClaveClie(String claveClie) {
        this.claveClie = claveClie;
    }

    public String getCorreoCli() {
        return correoCli;
    }

    public void setCorreoCli(String correoCli) {
        this.correoCli = correoCli;
    }
    
    
    
    
}
