package ice.me.emicharacters.mixin;

import ice.me.emicharacters.FakeArray;
import net.minecraft.client.search.SuffixArray;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(targets = {
        "dev.emi.emi.search.EmiSearch"
}, remap = false)
public abstract class MixinEmiSearch {

    @Redirect(method = "bake", at = @At(value = "NEW", args = "class=net/minecraft/client/search/SuffixArray", remap = true))
    private static <T> SuffixArray<T> redirectConstructor() {
        return new FakeArray<T>();
    }
}
