package A123b;

import com.google.gson.annotations.JsonAdapter;

import java.time.LocalDateTime;

class Category {
    public int id;
    public String name;
    public String image;

    @JsonAdapter(LocalDateTimeAdapter.class)  // Usamos un adaptador para manejar LocalDateTime
    public LocalDateTime creationAt;

    @JsonAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime updatedAt;
}