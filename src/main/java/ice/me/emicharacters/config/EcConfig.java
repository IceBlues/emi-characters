package ice.me.emicharacters.config;

import me.towdium.pinin.Keyboard;
import me.towdium.pinin.PinIn;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EcConfig {
    public static final PinIn context = new PinIn().config().accelerate(true).commit();


    public void init() {
        Path path = FabricLoader.getInstance().getConfigDir()
                .resolve("emi-characters");

        try {
            // create if not exists
            path.toFile().createNewFile();

            List<String> line = Files.readAllLines(path);
            if (line.isEmpty()) {
                // set 0
                Files.writeString(path, "0");
            } else {
                // read and judge
                String flag = line.get(0);
                if (!"0".equals(flag)) {
                    context.config().keyboard(Keyboard.XIAOHE).commit();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
