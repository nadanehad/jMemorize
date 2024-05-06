package jmemorize.gui.swing.panels;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;

public class AxisConfiguration {
    private final CategoryAxis domainAxis;
    private final ValueAxis rangeAxis;

    public AxisConfiguration(CategoryAxis domainAxis, ValueAxis rangeAxis) {
        this.domainAxis = domainAxis;
        this.rangeAxis = rangeAxis;
    }

    public CategoryAxis getDomainAxis() {
        return domainAxis;
    }

    public ValueAxis getRangeAxis() {
        return rangeAxis;
    }
}
