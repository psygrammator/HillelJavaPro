package top.jsoft.homework.design.strategy;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@NoArgsConstructor
@Data
public class GetSquare {
    private ISquare iSquare;

    public double getSquare(int val)
    {
        if(iSquare != null)
        {
            return iSquare.getSquare(val);
        }
        throw new RuntimeException("iSquare == null");
    }
}
