package Main.Graphs;

import java.util.Date;

//Data objects hold the values of a line imported from the selected CSV file.
public class Data {
    private int id;
    private double frequency, demand, coal, nuclear, ccgt, wind, french_ict, dutch_ict, irish_ict, ew_ict, pumped, hydro, oil, other, ocgt, solar;
    private Date date;

    //Forms the data objects based on values from the CSV
    public Data(int id, Date date, double demand, double frequency, double coal, double nuclear, double ccgt, double wind, double french_ict, double dutch_ict, double irish_ict, double ew_ict, double pumped, double hydro, double oil, double ocgt, double other, double solar) {
        this.ocgt = ocgt;
        this.ccgt = ccgt;
        this.coal = coal;
        this.demand = demand;
        this.dutch_ict = dutch_ict;
        this.ew_ict = ew_ict;
        this.french_ict = french_ict;
        this.frequency = frequency;
        this.hydro = hydro;
        this.id = id;
        this.irish_ict = irish_ict;
        this.nuclear = nuclear;
        this.wind = wind;
        this.pumped = pumped;
        this.oil = oil;
        this.other = other;
        this.solar = solar;
        this.date = date;
    }

    //method to convert a data object to a readable format.
    public String toString(){
        return "Id:"+ id + ", Date:" + date + ", Frequency:" + frequency + ", Coal:" + coal + ", Nuclear:" + nuclear +
                ", CCGT:" + ccgt + ", Wind:" + wind + ", French_ICT:" + french_ict + ", Dutch_ICT:" + dutch_ict + ", Irish_ICT" + irish_ict +
                ", EW_ICT:" + ew_ict + ", Pumped:" + pumped + ", Hydro:" + hydro + ", Oil:" + oil + ", OCGT:" + ocgt +
                ", Other:" + other + ", Solar:" + solar;
    }

    //simple getters - id not included
    public Date getDate() { return date; }
    public double getDemand() { return demand; }
    public double getFrequency() { return frequency; }
    public double getCoal() { return coal; }
    public double getNuclear() { return nuclear; }
    public double getCcgt() { return ccgt; }
    public double getWind() { return wind; }
    public double getFrench_ict() { return french_ict; }
    public double getDutch_ict() { return dutch_ict; }
    public double getIrish_ict() { return irish_ict; }
    public double getEw_ict() { return ew_ict; }
    public double getPumped() { return pumped; }
    public double getHydro() { return hydro; }
    public double getOil() { return oil; }
    public double getOcgt() { return ocgt; }
    public double getOther() { return other; }
    public double getSolar() { return solar; }
}
