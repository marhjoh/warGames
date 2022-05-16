package no.ntnu.idatg1002.wargamesapplication.corefunctionality;

public class ArmyCount {
    private String unitName;
    private int amount;

    public ArmyCount(String unitName, int amount) {
        this.unitName = unitName;
        this.amount = amount;
    }

    public String getUnitName() {
        return unitName;
    }

    public int getAmount() {
        return amount;
    }
}
