package com.solvd.delivery.television;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;

public class TelevisionInformation implements AutoCloseable{

    final static Level TV_LOG = Level.forName("TV_LOG", 700);
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
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

    @Override
    public void close(){
        LOGGER.log(TV_LOG,"Television is set");
    }
}
