package A123b;

import com.google.gson.annotations.JsonAdapter;

import java.time.LocalDateTime;
import java.util.List;

public class Product {
    public int id;
    public String title;
    public double price;
    public String description;
    public List<String> images;

    @JsonAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime creationAt;

    @JsonAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime updatedAt;

    public Category category;
}