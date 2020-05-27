package es_20;

public class ModelloTemperature {

    String anno;
    double tempInverno;
    double tempPrimavera;
    double tempEstate;
    double tempAutunno;
    double tempMedia;

    public ModelloTemperature(String anno, double tempInverno, double tempPrimavera,
                              double tempEstate, double tempAutunno, double tempMedia) {
        this.anno = anno;
        this.tempInverno = tempInverno;
        this.tempPrimavera = tempPrimavera;
        this.tempEstate = tempEstate;
        this.tempAutunno = tempAutunno;
        this.tempMedia = tempMedia;
    }

    //Costruttore di copia
    public ModelloTemperature(ModelloTemperature m1)
    {
        this.anno = m1.anno;
        this.tempInverno = m1.tempInverno;
        this.tempPrimavera = m1.tempPrimavera;
        this.tempEstate = m1.tempEstate;
        this.tempAutunno = m1.tempAutunno;
        this.tempMedia = m1.tempMedia;
    }

    public ModelloTemperature(){}

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public double getTempInverno() {
        return tempInverno;
    }

    public void setTempInverno(double tempInverno) {
        this.tempInverno = tempInverno;
    }

    public double getTempPrimavera() {
        return tempPrimavera;
    }

    public void setTempPrimavera(double tempPrimavera) {
        this.tempPrimavera = tempPrimavera;
    }

    public double getTempEstate() {
        return tempEstate;
    }

    public void setTempEstate(double tempEstate) {
        this.tempEstate = tempEstate;
    }

    public double getTempAutunno() {
        return tempAutunno;
    }

    public void setTempAutunno(double tempAutunno) {
        this.tempAutunno = tempAutunno;
    }

    public double getTempMedia() {
        return tempMedia;
    }

    public void setTempMedia(double tempMedia) {
        this.tempMedia = tempMedia;
    }

    @Override
    public String toString() {
        return "ModelloTemperature{" +
                "anno='" + anno + '\'' +
                ", tempInverno=" + tempInverno +
                ", tempPrimavera=" + tempPrimavera +
                ", tempEstate=" + tempEstate +
                ", tempAutunno=" + tempAutunno +
                ", tempMedia=" + tempMedia +
                '}';
    }

    public String toStringInformale() {
        return "Anno: " + anno + "\n" +
                "Temp. Inverno: " + tempInverno + "\n" +
                "Temp. Primavera: " + tempPrimavera + "\n" +
                "Temp. Estate: " + tempEstate + "\n" +
                "Temp. Autunno: " + tempAutunno + "\n" +
                "Media Annuale: " + tempMedia + "\n\n";
    }
}
