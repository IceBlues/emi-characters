package ice.me.emicharacters;

import ice.me.emicharacters.config.EcConfig;
import me.towdium.pinin.searchers.TreeSearcher;
import net.minecraft.client.search.SuffixArray;

import java.util.List;

import static me.towdium.pinin.searchers.Searcher.Logic.CONTAIN;

public class FakeArray<T> extends SuffixArray<T> {
    TreeSearcher<T> tree = new TreeSearcher<>(CONTAIN, EcConfig.context);

    @Override
    public void add(T v, String k) {
        tree.put(k, v);
    }

    @Override
    public void build() {
    }

    @Override
    public List<T> findAll(String k) {
        return tree.search(k);
    }
}