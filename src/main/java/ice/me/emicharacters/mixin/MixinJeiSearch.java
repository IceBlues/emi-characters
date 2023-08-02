package ice.me.emicharacters.mixin;

import ice.me.emicharacters.FakeTree;
import mezz.jei.core.search.PrefixInfo;
import mezz.jei.core.search.suffixtree.GeneralizedSuffixTree;
import mezz.jei.gui.ingredients.IListElementInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Collection;
import java.util.function.Supplier;

@Pseudo
@Mixin(targets = {
        "mezz.jei.gui.search.ElementPrefixParser"
}, remap = false)
public abstract class MixinJeiSearch {
    @Shadow
    public abstract Collection<PrefixInfo<IListElementInfo<?>>> allPrefixInfos();

    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lmezz/jei/core/search/PrefixInfo;<init>(CLmezz/jei/core/search/PrefixInfo$IModeGetter;Lmezz/jei/core/search/PrefixInfo$IStringsGetter;Ljava/util/function/Supplier;)V"), remap = false)
    private Supplier<?> modifyConstructorInit(Supplier<?> supplier) {
        if (supplier.get() instanceof GeneralizedSuffixTree) {
            return FakeTree::new;
        }
        System.out.println("Fuck!");
        return supplier;
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lmezz/jei/core/search/PrefixInfo;<init>(CLmezz/jei/core/search/PrefixInfo$IModeGetter;Lmezz/jei/core/search/PrefixInfo$IStringsGetter;Ljava/util/function/Supplier;)V"), remap = false)
    private static Supplier<?> modifyConstructorClInit(Supplier<?> supplier) {
        return FakeTree::new;
    }

}
