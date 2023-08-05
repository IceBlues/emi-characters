package ice.me.emicharacters.mixin;

import ice.me.emicharacters.Match;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings({"UnresolvedMixinReference", "mapping"})
@Pseudo
@Mixin(targets = "appeng.client.gui.me.search.SearchPredicates", remap = false)
public class MixinAE2b {

    @Redirect(method = "lambda$createNamePredicate$3(Ljava/util/regex/Pattern;Lappeng/menu/me/common/GridInventoryEntry;)Z", at = @At(value = "INVOKE", target = "Ljava/util/regex/Pattern;matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;", remap = false))
    private static Matcher redirectRegx(Pattern pattern, CharSequence sequence) {
        return Match.matcher(pattern, sequence);
    }

}