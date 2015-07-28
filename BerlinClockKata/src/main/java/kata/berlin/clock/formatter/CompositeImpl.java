package kata.berlin.clock.formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Thomas on 7/8/2015.
 */
public class CompositeImpl implements IComposite<String> {

    private List<IComposite> children;

    public CompositeImpl(List<IComposite> children) {
        this.children = children;
    }

    public CompositeImpl() {
        this(new ArrayList<IComposite>());
    }

    @Override
    public String compose() {
        return children.stream()
                .map((IComposite<String>::compose))
                .collect(Collectors.joining());
    }

    public void addChild(IComposite child) {
        children.add(child);
    }
}
