package com.solvd.delivery.television;

import java.util.List;
import java.util.Set;

public class TelevisionInformation {
    private Set<String> infoForTV;
    private List<String> listOfDonors;

    public List<String> getListOfDonors() {
        return this.listOfDonors;
    }

    public void setListOfDonors(List<String> listOfDonors) {
        this.listOfDonors = listOfDonors;
    }

    public Set<String> getInfoForTV() {
        return this.infoForTV;
    }

    public void setInfoForTV(Set<String> infoForTV) {
        this.infoForTV = infoForTV;
    }
}
