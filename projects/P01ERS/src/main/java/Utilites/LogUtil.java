package Utilites;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class LogUtil {
	
	private static Logger log = LogManager.getRootLogger();
	public static void whatHappended(String note){
        log.error(note);
    }
}
