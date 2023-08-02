package ice.me.emicharacters;

import ice.me.emicharacters.config.EcConfig;
import me.towdium.pinin.searchers.TreeSearcher;
import mezz.jei.core.search.suffixtree.GeneralizedSuffixTree;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Consumer;

import static me.towdium.pinin.searchers.Searcher.Logic.CONTAIN;

public class FakeTree<T> extends GeneralizedSuffixTree<T> {

    TreeSearcher<T> tree = new TreeSearcher<>(CONTAIN, EcConfig.context);

    @Override
    public void getSearchResults(String word, Consumer<Collection<T>> results) {
        results.accept(tree.search(word));
    }

    @Override
    public void put(String key, T value) {
        tree.put(key, value);
    }

    @Override
    public void getAllElements(Consumer<Collection<T>> results) {
        results.accept(tree.search(""));
    }

    @Override
    public @NotNull String statistics() {
        return "Nope!";
    }
}