package people;

public enum University {
    ATM("ATM"),
    ASE("ASE"),
    UBB("UBB"),
    UBP("UPB");
    private String acronym;
    University(String acronym) {
        this.acronym=acronym;
    }
    public String getAcronym(){ return this.acronym;}
    public static University getUni(String uni){
        switch (uni){
            case "ATM":
                return University.ATM;
            case "ASE":
                return University.ASE;
            case "UBB":
                return University.UBB;
            default:
                return University.UBP;
        }
    }
}
