package automationexercise.pages;

public enum CountryOption {

    India("India", 0),
    UnitedStates("United States", 1),
    Canada("Canada", 2),
    Australia("Australia", 3),
    Israel("Israel", 4),
    NewZealand("New Zealand", 5),
    Singapore("Singapore", 6);

    private final String countryValue; 
    private final int countryIndex;     

    // Constructor to initialize the values
    CountryOption(String countryValue, int countryIndex) {
        this.countryValue = countryValue;
        this.countryIndex = countryIndex;
    }

    // Getter for the country value
    public String getCountryValue() {
        return countryValue;
    }

    // Getter for the country index
    public int getCountryIndex() {
        return countryIndex;  
}
}