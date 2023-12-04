package top.jsoft.springmvc2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private List<String> news;
}
