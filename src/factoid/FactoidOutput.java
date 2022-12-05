package factoid;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactoidOutput implements IFactoid {
    static Logger logger = LogManager.getLogger(FactoidOutput.class);

    @Override
    public void outputFactoid() {
        logger.info("Did you know?: THE POSTAL SERVICE EMPLOYS MORE THAN 7.5 MILLION PEOPLE.");
        logger.info("The U.S. postal service is the reason more than 7.5 million people have jobs. " +
                "The mailing industry brought in $70.6 billion in operating revenues in 2018.");
        logger.info("Source: Redbook (bit.ly/3VsbI6S)");
    }
}
