package tech.rebb.dt;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Aggregator {

    private BuildInAggregation aggregation;

    public Aggregator(BuildInAggregation aggregation)
    {
        this.aggregation = aggregation;
    }

    public Object run(ArrayList<Object> data)
    {
        if(this.aggregation == BuildInAggregation.NA)
            return null;
        else if(this.aggregation == BuildInAggregation.COUNT)
            return data.size();
        else if(this.aggregation == BuildInAggregation.MIN) {

            Double min_obj = Double.MAX_VALUE;
            for (Object datum : data) {
                Double obj = Double.parseDouble(datum.toString());
                if (obj < min_obj)
                    min_obj = obj;
            }
            return min_obj;
        }
        else if(this.aggregation == BuildInAggregation.MAX) {
            Double max_obj = Double.MIN_VALUE;
            for (Object datum : data) {
                double obj = Double.parseDouble(datum.toString());
                if (obj > max_obj)
                    max_obj = obj;
            }
            return max_obj;
        }
        else if(this.aggregation == BuildInAggregation.SUM) {
            Double sum = 0.0;
            for (Object datum : data) {
                Double obj = Double.parseDouble(datum.toString());
                sum += obj;
            }
            return sum;
        }
        else
            return null;
    }
}
