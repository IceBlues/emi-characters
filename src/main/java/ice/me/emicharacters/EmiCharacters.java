package ice.me.emicharacters;

import ice.me.emicharacters.config.EcConfig;
import me.towdium.pinin.PinIn;
import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmiCharacters implements ClientModInitializer {
    public static final String MODID = "EmiCharacters";
    public static final Logger logger = LogManager.getLogger(MODID);

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitializeClient() {
        logger.info("emi-characters init");
        new EcConfig().init();
    }


}
