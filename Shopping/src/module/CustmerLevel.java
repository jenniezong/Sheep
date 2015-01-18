package module;

public enum CustmerLevel {

    Default(0), Gold(1), Silver(2), Bronze(3);
    private int dbValue;

    private CustmerLevel(int dbValue) {
	this.dbValue = dbValue;
    }

    public int getDbValue() {
	return dbValue;
    }

}
