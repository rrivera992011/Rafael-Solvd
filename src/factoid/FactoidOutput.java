package factoid;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactoidOutput implements IFactoid {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level FACTOID_LOG = Level.forName("FACTOID_LOG", 700);

    @Override
    public void outputFactoid() {
        LOGGER.log(FACTOID_LOG,"Did you know?: THE POSTAL SERVICE EMPLOYS MORE THAN 7.5 MILLION PEOPLE.");
        LOGGER.log(FACTOID_LOG,"The U.S. postal service is the reason more than 7.5 million people have jobs. " +
                "The mailing industry brought in $70.6 billion in operating revenues in 2018.");
        LOGGER.log(FACTOID_LOG,"Source: Redbook (bit.ly/3VsbI6S)");
    }
}
