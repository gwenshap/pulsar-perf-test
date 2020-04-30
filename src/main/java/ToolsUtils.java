import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;

import java.util.Map;
import java.util.TreeMap;

public class ToolsUtils {

    /**
     * print out the metrics in alphabetical order
     * @param metrics   the metrics to be printed out
     */
    public static void printMetrics(Map<MetricName, ? extends Metric> metrics) {
        if (metrics != null && !metrics.isEmpty()) {
            int maxLengthOfDisplayName = 0;
            TreeMap<String, Object> sortedMetrics = new TreeMap<>();
            for (Metric metric : metrics.values()) {
                MetricName mName = metric.metricName();
                String mergedName = mName.group() + ":" + mName.name() + ":" + mName.tags();
                maxLengthOfDisplayName = maxLengthOfDisplayName < mergedName.length() ? mergedName.length() : maxLengthOfDisplayName;
                sortedMetrics.put(mergedName, metric.metricValue());
            }
            String doubleOutputFormat = "%-" + maxLengthOfDisplayName + "s : %.3f";
            String defaultOutputFormat = "%-" + maxLengthOfDisplayName + "s : %s";
            System.out.println(String.format("\n%-" + maxLengthOfDisplayName + "s   %s", "Metric Name", "Value"));

            for (Map.Entry<String, Object> entry : sortedMetrics.entrySet()) {
                String outputFormat;
                if (entry.getValue() instanceof Double)
                    outputFormat = doubleOutputFormat;
                else
                    outputFormat = defaultOutputFormat;
                System.out.println(String.format(outputFormat, entry.getKey(), entry.getValue()));
            }
        }
    }
}