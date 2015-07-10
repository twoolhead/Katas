package kata.berlin.clock.formatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 7/8/2015.
 */
public class ChronologicalFormatComposite implements IChronologicalFormat {

    private List<IChronologicalFormat> formattedChildren;

    public ChronologicalFormatComposite(List<IChronologicalFormat> formattedChildren) {
        this.formattedChildren = formattedChildren;
    }

    public ChronologicalFormatComposite() {
        this(new ArrayList<IChronologicalFormat>());
    }

    @Override
    public String getFormatted() {
        final StringBuilder formatHierarchy = new StringBuilder();

        for(IChronologicalFormat format : formattedChildren) {
            formatHierarchy.append(format.getFormatted());
        }

        return formatHierarchy.toString();
    }

    public void addFormatted(IChronologicalFormat chronologicalFormat) {
        formattedChildren.add(chronologicalFormat);
    }
}
